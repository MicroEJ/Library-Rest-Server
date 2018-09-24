/*
 * Java
 *
 * Copyright 2017-2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver.endpoint;

import java.io.InputStream;
import java.util.Map;

import ej.hoka.http.HTTPConstants;
import ej.hoka.http.HTTPRequest;
import ej.hoka.http.HTTPResponse;
import ej.hoka.http.support.MIMEUtils;
import ej.restserver.RestEndpoint;
import ej.restserver.RestResponse;

/**
 * A static resource end-point to serve all kind of files.
 */
public class ResourceRestEndpoint extends RestEndpoint {

	/**
	 * Path to embedded resource to serve.
	 */
	protected String resource;

	/**
	 * Creates a static resource end-point that responds to given URI and serves given resource.
	 *
	 * @param uri
	 *            the end-point URI.
	 * @param resource
	 *            the resource to serve.
	 */
	public ResourceRestEndpoint(String uri, String resource) {
		super(uri);
		if (resource == null) {
			throw new NullPointerException();
		}
		this.resource = resource;
	}

	/**
	 * Gets the resource to serve as an input stream.
	 *
	 * @return an input stream on the resource to serve, or {@code null} if resource is not found.
	 */
	protected InputStream getResourceAsStream() {
		return this.getClass().getResourceAsStream(this.resource);
	}

	/**
	 * Gets the resource to serve as an HTTP response. By default, it serves embedded resource with
	 * {@code application/octet-stream} content type.
	 *
	 * @return the HTTP response corresponding to the resource to serve.
	 *
	 * @see MIMEUtils#MIME_DEFAULT_BINARY
	 */
	protected HTTPResponse getResourceResponse() {
		InputStream resourceAsStream = this.getResourceAsStream();
		if (resourceAsStream == null) {
			return HTTPResponse.RESPONSE_NOT_FOUND;
		}

		String mimeType = MIMEUtils.getMIMEType(this.resource);
		if (mimeType == null) {
			mimeType = MIMEUtils.MIME_DEFAULT_BINARY;
		}

		return new RestResponse(HTTPConstants.HTTP_STATUS_OK, mimeType, resourceAsStream);
	}

	@Override
	public HTTPResponse get(HTTPRequest request, Map<String, String> headers, Map<String, String> parameters) {
		return this.getResourceResponse();
	}

}
