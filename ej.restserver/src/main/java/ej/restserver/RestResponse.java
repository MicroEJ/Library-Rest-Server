/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import ej.hoka.http.HTTPConstants;
import ej.hoka.http.HTTPResponse;

/**
 * A simple wrapper over HTTP response, allowing to directly specify MIME type and status code.
 */
public class RestResponse extends HTTPResponse {

	/**
	 * Default content encoding for Rest response.
	 */
	public static final String DEFAULT_ENCODING = "ISO-8859-1"; //$NON-NLS-1$

	/**
	 * Creates a new REST response.
	 *
	 * @param status
	 *            the response status.
	 * @param mimeType
	 *            the response MIME type
	 * @param data
	 *            the data to send.
	 *
	 * @see HTTPConstants#HTTP_STATUS_BADREQUEST
	 * @see HTTPConstants#HTTP_STATUS_FORBIDDEN
	 * @see HTTPConstants#HTTP_STATUS_INTERNALERROR
	 * @see HTTPConstants#HTTP_STATUS_MEDIA_TYPE
	 * @see HTTPConstants#HTTP_STATUS_METHOD
	 * @see HTTPConstants#HTTP_STATUS_NOTACCEPTABLE
	 * @see HTTPConstants#HTTP_STATUS_NOTFOUND
	 * @see HTTPConstants#HTTP_STATUS_NOTIMPLEMENTED
	 * @see HTTPConstants#HTTP_STATUS_NOTMODIFIED
	 * @see HTTPConstants#HTTP_STATUS_OK
	 * @see HTTPConstants#HTTP_STATUS_REDIRECT
	 */
	public RestResponse(String status, String mimeType, InputStream data) {
		super(data);
		if (status == null || mimeType == null) {
			throw new NullPointerException();
		}
		setMimeType(mimeType);
		setStatus(status);
	}

	/**
	 * Creates a new REST response.
	 *
	 * @param status
	 *            the response status.
	 * @param mimeType
	 *            the response MIME type
	 * @param text
	 *            the data to send, using default encoding.
	 * @throws UnsupportedEncodingException
	 *             if default encoding is not supported.
	 *
	 * @see RestResponse#DEFAULT_ENCODING
	 *
	 * @see HTTPConstants#HTTP_STATUS_BADREQUEST
	 * @see HTTPConstants#HTTP_STATUS_FORBIDDEN
	 * @see HTTPConstants#HTTP_STATUS_INTERNALERROR
	 * @see HTTPConstants#HTTP_STATUS_MEDIA_TYPE
	 * @see HTTPConstants#HTTP_STATUS_METHOD
	 * @see HTTPConstants#HTTP_STATUS_NOTACCEPTABLE
	 * @see HTTPConstants#HTTP_STATUS_NOTFOUND
	 * @see HTTPConstants#HTTP_STATUS_NOTIMPLEMENTED
	 * @see HTTPConstants#HTTP_STATUS_NOTMODIFIED
	 * @see HTTPConstants#HTTP_STATUS_OK
	 * @see HTTPConstants#HTTP_STATUS_REDIRECT
	 */
	public RestResponse(String status, String mimeType, String text) throws UnsupportedEncodingException {
		this(status, mimeType, text, DEFAULT_ENCODING);
	}

	/**
	 * Creates a new REST response.
	 *
	 * @param status
	 *            the response status.
	 * @param mimeType
	 *            the response MIME type
	 * @param text
	 *            the data to send.
	 * @param encoding
	 *            the data encoding.
	 * @throws UnsupportedEncodingException
	 *             if given data encoding is not supported.
	 *
	 * @see HTTPConstants#HTTP_STATUS_BADREQUEST
	 * @see HTTPConstants#HTTP_STATUS_FORBIDDEN
	 * @see HTTPConstants#HTTP_STATUS_INTERNALERROR
	 * @see HTTPConstants#HTTP_STATUS_MEDIA_TYPE
	 * @see HTTPConstants#HTTP_STATUS_METHOD
	 * @see HTTPConstants#HTTP_STATUS_NOTACCEPTABLE
	 * @see HTTPConstants#HTTP_STATUS_NOTFOUND
	 * @see HTTPConstants#HTTP_STATUS_NOTIMPLEMENTED
	 * @see HTTPConstants#HTTP_STATUS_NOTMODIFIED
	 * @see HTTPConstants#HTTP_STATUS_OK
	 * @see HTTPConstants#HTTP_STATUS_REDIRECT
	 */
	public RestResponse(String status, String mimeType, String text, String encoding)
			throws UnsupportedEncodingException {
		super(text, encoding);
		if (status == null || mimeType == null) {
			throw new NullPointerException();
		}
		setStatus(status);
		setMimeType(mimeType);
	}

}
