/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver;

import java.util.Hashtable;

import ej.hoka.http.HTTPRequest;

/**
 *
 */
public abstract class RestEndpoint {

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

	public RestResponse get(HTTPRequest request, Hashtable<String, String> headers,
			Hashtable<String, String> parameters) {
		return unimplemented();
	}

	public RestResponse post(HTTPRequest request, Hashtable<String, String> headers,
			Hashtable<String, String> parameters) {
		return unimplemented();
	}

	public RestResponse put(HTTPRequest request, Hashtable<String, String> headers,
			Hashtable<String, String> parameters) {
		return unimplemented();
	}

	public RestResponse delete(HTTPRequest request, Hashtable<String, String> headers,
			Hashtable<String, String> parameters) {
		return unimplemented();
	}

	public abstract RestResponse ok();

	public abstract RestResponse movePermanently();

	public abstract RestResponse notModified();

	public abstract RestResponse forbidden();

	public abstract RestResponse notFound();

	public abstract RestResponse notAllowed();

	public abstract RestResponse notAcceptable();

	public abstract RestResponse badRequest();

	public abstract RestResponse unsupportedMediaType();

	public abstract RestResponse internalError();

	public abstract RestResponse unimplemented();

}
