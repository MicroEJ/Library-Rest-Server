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

/**
 * An endpoint handler handles GET, POST, PUT and DELETE operations on server endpoints.
 *
 * @see RestEndpoint
 * @see RestServer#addEndpoint(RestEndpoint)
 */
public class EndpointHandler implements RequestHandler {

	@Override
	public HTTPResponse answer(RestServer server, HTTPRequest request) {
		String uri = request.getURI();
		for (RestEndpoint endpoint : server.getEndpoints()) {
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
					return HTTPResponse.RESPONSE_NOT_FOUND;
				}
			}
		}
		return null;
	}

}
