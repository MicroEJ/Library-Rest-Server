/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver;

import java.util.Hashtable;

import ej.hoka.http.HTTPRequest;
import ej.hoka.http.HTTPResponse;

/**
 *
 */
public class RestEndpoint {

	private static final String ENDPOINT_PREFIX = "/"; //$NON-NLS-1$

	protected String uri;

	public RestEndpoint(String uri) {
		if (uri == null) {
			throw new NullPointerException();
		}

		if (uri.isEmpty()) {
			throw new IllegalArgumentException("URI cannot be empty"); //$NON-NLS-1$
		}

		if (!uri.startsWith(ENDPOINT_PREFIX)) {
			uri = ENDPOINT_PREFIX + uri;
		}

		this.uri = uri;
	}

	public String getURI() {
		return this.uri;
	}

	public HTTPResponse get(HTTPRequest request, Hashtable<String, String> headers,
			Hashtable<String, String> parameters) {
		return HTTPResponse.RESPONSE_NOT_IMPLEMENTED;
	}

	public HTTPResponse post(HTTPRequest request, Hashtable<String, String> headers,
			Hashtable<String, String> parameters) {
		return HTTPResponse.RESPONSE_NOT_IMPLEMENTED;
	}

	public HTTPResponse put(HTTPRequest request, Hashtable<String, String> headers,
			Hashtable<String, String> parameters) {
		return HTTPResponse.RESPONSE_NOT_IMPLEMENTED;
	}

	public HTTPResponse delete(HTTPRequest request, Hashtable<String, String> headers,
			Hashtable<String, String> parameters) {
		return HTTPResponse.RESPONSE_NOT_IMPLEMENTED;
	}

}
