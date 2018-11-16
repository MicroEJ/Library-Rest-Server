/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver.endpoint;

import java.util.Hashtable;

import ej.hoka.http.HTTPRequest;
import ej.hoka.http.HTTPResponse;
import ej.restserver.RestEndpoint;

/**
 * An endpoint forwarding its requests to another {@link RestEndpoint}.
 */
public class AliasEndpoint extends RestEndpoint {

	private RestEndpoint endpoint;

	/**
	 * Instantiates a {@link AliasEndpoint}.
	 *
	 * @param uri
	 *            the uri, cannot be <code>null</code>.
	 * @param endpoint
	 *            the end point to forward the request to, cannot be <code>null</code>.
	 * @throws IllegalArgumentException
	 *             if URI is empty
	 */
	public AliasEndpoint(String uri, RestEndpoint endpoint) {
		super(uri);
		if (endpoint == null) {
			throw new NullPointerException();
		}
		this.endpoint = endpoint;
	}

	/**
	 * Gets the endpoint.
	 *
	 * @return the endpoint.
	 */
	public RestEndpoint getEndpoint() {
		return this.endpoint;
	}

	/**
	 * Sets the endpoint.
	 *
	 * @param endpoint
	 *            the endpoint to set, cannot be <code>null</code>.
	 */
	public void setEndpoint(RestEndpoint endpoint) {
		if (endpoint == null) {
			throw new NullPointerException();
		}
		this.endpoint = endpoint;
	}

	@Override
	public HTTPResponse get(HTTPRequest request, Hashtable<String, String> headers,
			Hashtable<String, String> parameters) {
		return this.endpoint.get(request, headers, parameters);
	}

	@Override
	public HTTPResponse post(HTTPRequest request, Hashtable<String, String> headers,
			Hashtable<String, String> parameters) {
		return this.endpoint.post(request, headers, parameters);
	}

	@Override
	public HTTPResponse put(HTTPRequest request, Hashtable<String, String> headers,
			Hashtable<String, String> parameters) {
		return this.endpoint.put(request, headers, parameters);
	}

	@Override
	public HTTPResponse delete(HTTPRequest request, Hashtable<String, String> headers,
			Hashtable<String, String> parameters) {
		return this.endpoint.delete(request, headers, parameters);
	}

}
