/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver;

import java.util.Hashtable;

import ej.hoka.http.HTTPRequest;
import ej.hoka.http.HTTPResponse;
import ej.hoka.http.HTTPSession;

public class RestSession extends HTTPSession {

	private final RestServer server;

	public RestSession(RestServer server) {
		super(server);
		this.server = server;
	}

	@Override
	protected HTTPResponse answer(HTTPRequest request) {
		String uri = request.getURI();
		for (RestEndpoint endpoint : this.server.getEndpoints()) {
			if (endpoint.getURI().equals(uri)) {
				Hashtable<String, String> headers = request.getHeader();
				Hashtable<String, String> parameters = request.getParameters();
				switch (request.getMethod()) {
				case HTTPRequest.GET:
					return endpoint.get(request, headers, parameters);
				case HTTPRequest.POST:
					return endpoint.post(request, headers, parameters);
				case HTTPRequest.PUT:
					return endpoint.put(request, headers, parameters);
				case HTTPRequest.DELETE:
					return endpoint.delete(request, headers, parameters);
				default:
					throw new RuntimeException("Unhandled HTTP verb"); //$NON-NLS-1$
				}
			}
		}
		throw new RuntimeException("Unhandled Endpoint " + uri); //$NON-NLS-1$
	}

}
