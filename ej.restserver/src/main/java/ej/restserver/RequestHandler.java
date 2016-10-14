/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver;

import ej.hoka.http.HTTPRequest;
import ej.hoka.http.HTTPResponse;

/**
 * A request handler is responsible of HTTP requests processing. It may or may not serve resources for a given HTTP
 * request.
 */
public interface RequestHandler {

	/**
	 * Answers to the given HTTP request. Depending on request parameters, this handler may or may not returns a HTTP
	 * response.
	 *
	 * @param server
	 *            the server handling the request.
	 * @param request
	 *            the HTTP request.
	 * @return an HTTP response if this handler can process the HTTP request, or {@code null} otherwise.
	 */
	HTTPResponse answer(RestServer server, HTTPRequest request);

}
