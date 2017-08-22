/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import ej.hoka.http.HTTPServer;
import ej.hoka.http.HTTPSession;

/**
 * A simple implementation of HTTP server capable of easily exposing endpoints.
 *
 * <p>
 * REST servers can always handle requests that target endpoints. Other kind of request are handles by custom request
 * handlers.
 *
 * @see EndpointHandler
 * @see RequestHandler
 */
public class RestServer extends HTTPServer {

	private final List<RestEndpoint> endpoints;
	private final List<RequestHandler> requestHandlers;

	/**
	 * Creates a new server bounded to given port.
	 *
	 * <p>
	 * This constructor looks for server socket service implementation using a Service Loader. The returned server
	 * socket will be used. If no service is declared, default implementation is used (Java standard server socket).
	 *
	 * @param port
	 *            the port.
	 * @param maxSimultaneousConnection
	 *            the maximal number of simultaneously opened connections.
	 * @param jobCountBySession
	 *            the number of parallel jobs to process by opened sessions.
	 * @throws IOException
	 *             if server cannot be bind to given port.
	 */
	public RestServer(int port, int maxSimultaneousConnection, int jobCountBySession) throws IOException {
		super(new ServerSocket(port), maxSimultaneousConnection, jobCountBySession);

		this.endpoints = new LinkedList<RestEndpoint>();
		this.requestHandlers = new LinkedList<RequestHandler>();
		this.requestHandlers.add(new EndpointHandler());
	}

	/**
	 * Adds an endpoint to this server.
	 *
	 * @param endpoint
	 *            the endpoint to add.
	 */
	public void addEndpoint(RestEndpoint endpoint) {
		this.endpoints.add(endpoint);
	}

	/**
	 * Adds a request handler to this server. Given resolver becomes immediately active.
	 *
	 * @param handler
	 *            the handler to add.
	 */
	public void addRequestResolver(RequestHandler handler) {
		this.requestHandlers.add(handler);
	}

	/**
	 * Gets the list of active endpoints.
	 *
	 * @return an unmodifiable list of server active endpoints.
	 */
	public List<RestEndpoint> getEndpoints() {
		return Collections.unmodifiableList(this.endpoints);
	}

	/**
	 * Gets the list of active request handlers. It contains at least an endpoint handler.
	 *
	 * @return an non-empty and unmodifiable list of server active request handlers.
	 *
	 * @see EndpointHandler
	 */
	public List<RequestHandler> getRequestResolvers() {
		return Collections.unmodifiableList(this.requestHandlers);
	}

	@Override
	protected HTTPSession newHTTPSession() {
		return new RestSession(this);
	}

}
