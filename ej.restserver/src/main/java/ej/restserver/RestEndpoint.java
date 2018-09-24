/*
 * Java
 *
 * Copyright 2016-2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver;

import java.util.Map;

import ej.hoka.http.HTTPRequest;
import ej.hoka.http.HTTPResponse;

/**
 * A REST endpoint exposes resources on a REST server.
 *
 * <p>
 * Allow HTTP verbs are {@code GET}, {@code POST}, {@code PUT} and {@code DELETE}.
 */
public class RestEndpoint {

	private static final String ENDPOINT_PREFIX = "/"; //$NON-NLS-1$

	/**
	 * The URI this endpoint answers.
	 */
	protected String uri;

	/**
	 * Create a new endpoint at given URI.
	 *
	 * <p>
	 * For example, assuming a REST server running at {@code 127.0.0.1:80}, following code creates an endpoint at
	 * {@code http://127.0.0.1:80/my/custom/endpoint}
	 *
	 * <pre>
	 * server.add(new RestEndpoint("/my/custom/endpoint"));
	 * </pre>
	 *
	 * If URI does not start with a {@code /} character, it is automatically added.
	 *
	 * @param uri
	 *            the URI of this endpoint.
	 * @throws IllegalArgumentException
	 *             if URI is empty
	 */
	public RestEndpoint(String uri) throws IllegalArgumentException {
		if (uri == null) {
			throw new NullPointerException();
		}

		uri = uri.trim();

		if (uri.isEmpty()) {
			throw new IllegalArgumentException("URI cannot be empty"); //$NON-NLS-1$
		}

		if (!uri.startsWith(ENDPOINT_PREFIX)) {
			uri = ENDPOINT_PREFIX + uri;
		}

		this.uri = uri;
	}

	/**
	 * Gets this endpoint URI.
	 *
	 * @return this endpoint URI.
	 */
	public String getURI() {
		return this.uri;
	}

	/**
	 * Handles {@code GET} request on this endpoint.
	 *
	 * <p>
	 * Default implementation return a a status code {@code 501}
	 *
	 * @param request
	 *            the request to handle.
	 * @param headers
	 *            request headers.
	 * @param parameters
	 *            parsed query and body parameters.
	 * @return an HTTP response.
	 */
	public HTTPResponse get(HTTPRequest request, Map<String, String> headers, Map<String, String> parameters) {
		return HTTPResponse.RESPONSE_NOT_IMPLEMENTED;
	}

	/**
	 * Handles {@code POST} request on this endpoint.
	 *
	 * <p>
	 * Default implementation return a a status code {@code 501}
	 *
	 * @param request
	 *            the request to handle.
	 * @param headers
	 *            request headers.
	 * @param parameters
	 *            parsed query and body parameters.
	 * @return an HTTP response.
	 */
	public HTTPResponse post(HTTPRequest request, Map<String, String> headers, Map<String, String> parameters) {
		return HTTPResponse.RESPONSE_NOT_IMPLEMENTED;
	}

	/**
	 * Handles {@code PUT} request on this endpoint.
	 *
	 * <p>
	 * Default implementation return a a status code {@code 501}
	 *
	 * @param request
	 *            the request to handle.
	 * @param headers
	 *            request headers.
	 * @param parameters
	 *            parsed query and body parameters.
	 * @return an HTTP response.
	 */
	public HTTPResponse put(HTTPRequest request, Map<String, String> headers, Map<String, String> parameters) {
		return HTTPResponse.RESPONSE_NOT_IMPLEMENTED;
	}

	/**
	 * Handles {@code DELETE} request on this endpoint.
	 *
	 * <p>
	 * Default implementation return a a status code {@code 501}
	 *
	 * @param request
	 *            the request to handle.
	 * @param headers
	 *            request headers.
	 * @param parameters
	 *            parsed query and body parameters.
	 * @return an HTTP response.
	 */
	public HTTPResponse delete(HTTPRequest request, Map<String, String> headers, Map<String, String> parameters) {
		return HTTPResponse.RESPONSE_NOT_IMPLEMENTED;
	}

}
