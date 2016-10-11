/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver;

import java.io.IOException;
import java.io.InputStream;

import ej.hoka.http.HTTPResponse;

/**
 *
 */
public class RestResponse extends HTTPResponse {

	/**
	 * Default content encoding for Rest response.
	 */
	public static final String DEFAULT_ENCODING = "ISO-8859-1"; //$NON-NLS-1$

	public RestResponse(String status, String mimeType, InputStream data) {
		super(data);
		if (status == null || mimeType == null) {
			throw new NullPointerException();
		}
		setMimeType(mimeType);
		setStatus(status);
	}

	public RestResponse(String status, String mimeType, String text) throws IOException {
		this(status, mimeType, text, DEFAULT_ENCODING);
	}

	public RestResponse(String status, String mimeType, String text, String encoding) throws IOException {
		super(text, encoding);
		if (status == null || mimeType == null) {
			throw new NullPointerException();
		}
		setStatus(status);
		setMimeType(mimeType);
	}

}
