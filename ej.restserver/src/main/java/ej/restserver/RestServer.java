/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.hoka.http.HTTPServer;
import ej.hoka.http.HTTPSession;
import ej.hoka.net.IServerSocketConnection;
import ej.restserver.socket.ServerSocketConnection;

/**
 *
 */
public class RestServer extends HTTPServer {

	private final LinkedList<RestEndpoint> endpoints;
	private final LinkedList<RequestHandler> requestHandlers;

	/**
	 * @param connection
	 * @param maxSimultaneousConnection
	 * @param jobCountBySession
	 * @throws IOException
	 */
	public RestServer(int port, int maxSimultaneousConnection, int jobCountBySession) throws IOException {
		super(ServiceLoaderFactory.getServiceLoader()
				.getService(IServerSocketConnection.class, ServerSocketConnection.class).setPort(port),
				maxSimultaneousConnection, jobCountBySession);
		this.endpoints = new LinkedList<RestEndpoint>();
		this.requestHandlers = new LinkedList<RequestHandler>();
		this.requestHandlers.add(new EndpointHandler());
	}

	public void addPath(RestEndpoint endpoint) {
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
