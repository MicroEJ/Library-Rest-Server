/*
 * Java
 *
 * Copyright 2017-2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver.endpoint;

import java.io.InputStream;

import ej.hoka.http.HTTPConstants;
import ej.hoka.http.HTTPResponse;
import ej.hoka.http.support.MIMEUtils;
import ej.restserver.RestResponse;

/**
 * A static resource end-point to serve gzip files.
 */
public class GzipResourceEndpoint extends ResourceRestEndpoint {

	/**
	 * Gzip file extension.
	 */
	public static final String GZIP_FILE_EXTENSION = ".gz"; //$NON-NLS-1$

	private static final String HEADER_CONTENT_ENCODING = "Content-Encoding"; //$NON-NLS-1$
	private static final String CONTENT_ENCODING_GZIP = "gzip"; //$NON-NLS-1$

	/**
	 * Creates a static gzip resource end-point that responds to given URI and serves given resource.
	 *
	 * @param uri
	 *            the end-point URI, cannot be <code>null</code>.
	 * @param resource
	 *            the GZip to serve, cannot be <code>null</code>.
	 */
	public GzipResourceEndpoint(String uri, String resource) {
		super(uri, resource);
	}

	/**
	 * Creates a static gzip resource end-point that responds to given URI and serves given resource.
	 *
	 * @param uri
	 *            the end-point URI, cannot be <code>null</code>.
	 * @param resource
	 *            the GZip to serve, cannot be <code>null</code>.
	 * @param mimetype
	 *            the mime type of the resource, if <code>null</code>, the mimetype will be computed.
	 * @see MIMEUtils#getMIMEType(String)
	 */
	public GzipResourceEndpoint(String uri, String resource, String mimetype) {
		super(uri, resource, mimetype);
	}

	@Override
	protected HTTPResponse getResourceResponse() {
		InputStream resourceAsStream = this.getResourceAsStream();
		if (resourceAsStream == null) {
			return HTTPResponse.RESPONSE_NOT_FOUND;
		}

		String mimeType = MIMEUtils
				.getMIMEType(this.resource.substring(0, this.resource.length() - GZIP_FILE_EXTENSION.length()));
		if (mimeType == null) {
			mimeType = MIMEUtils.MIME_DEFAULT_BINARY;
		}

		RestResponse response = new RestResponse(HTTPConstants.HTTP_STATUS_OK, mimeType, resourceAsStream);
		response.addHeaderField(HEADER_CONTENT_ENCODING, CONTENT_ENCODING_GZIP);
		return response;
	}

}
