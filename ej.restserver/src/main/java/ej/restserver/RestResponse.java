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

	public RestResponse(String status, String mimeType, InputStream data) {
		super(data);
		setMimeType(mimeType);
		setStatus(status);
	}

	public RestResponse(String status, String mimeType, String text) throws IOException {
		super(text == null ? "" : text);
		if (mimeType == null) {
			throw new NullPointerException();
		}

		setStatus(status);
		setMimeType(mimeType);
	}

	public RestResponse(String status, String mimeType, String text, String encoding) throws IOException {
		super(text == null ? "" : text, encoding);
		if (mimeType == null) {
			throw new NullPointerException();
		}

		setStatus(status);
		setMimeType(mimeType);
	}

}
