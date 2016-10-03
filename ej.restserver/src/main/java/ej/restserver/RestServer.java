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
	}

	public void addPath(RestEndpoint endpoint) {
		this.endpoints.add(endpoint);
	}

	public List<RestEndpoint> getEndpoints() {
		return Collections.unmodifiableList(this.endpoints);
	}

	@Override
	protected HTTPSession newHTTPSession() {
		return new RestSession(this);
	}

}
