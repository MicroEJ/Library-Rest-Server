/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver;

import ej.hoka.http.HTTPRequest;
import ej.hoka.http.HTTPResponse;
import ej.hoka.http.HTTPSession;

/**
 * A REST session handles HTTP requests.
 *
 * <p>
 * It loops over server active request handler to find the first one capable of handling the request and return its
 * response.
 */
public class RestSession extends HTTPSession {

	private final RestServer server;

	/**
	 * Creates a new REST session for given server.
	 *
	 * @param server
	 *            the underlying REST server.
	 */
	public RestSession(RestServer server) {
		super(server);
		this.server = server;
	}

	/**
	 * Answers to the given request.
	 *
	 * <p>
	 * Active server request resolvers are invokes one by one in order to respond to given request. Returned response is
	 * the one by the first resolver accepting to respond to the request.
	 */
	@Override
	protected HTTPResponse answer(HTTPRequest request) {
		for (RequestHandler handler : this.server.getRequestResolvers()) {
			HTTPResponse answer = handler.answer(this.server, request);
			if (answer != null) {
				return answer;
			}
		}

		return HTTPResponse.RESPONSE_NOT_FOUND;
	}

}
