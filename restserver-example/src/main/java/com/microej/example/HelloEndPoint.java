/*
* Java
*
* Copyright 2017-2018 IS2T. All rights reserved.
* For demonstration purpose only.
* IS2T PROPRIETARY. Use is subject to license terms.
*/
package com.microej.example;

import java.util.Map;

import ej.hoka.http.HTTPConstants;
import ej.hoka.http.HTTPRequest;
import ej.hoka.http.HTTPResponse;
import ej.restserver.RestEndpoint;

public class HelloEndPoint extends RestEndpoint {

	private static final String END_POINT = "/hello";

	public HelloEndPoint() throws IllegalArgumentException {
		super(END_POINT);
	}

	@Override
	public HTTPResponse delete(HTTPRequest request, Map<String, String> headers, Map<String, String> parameters) {
		HTTPResponse response = new HTTPResponse("REPLY " + END_POINT + " | DELETE");
		response.setStatus(HTTPConstants.HTTP_STATUS_OK);
		response.addHeaderField(HTTPConstants.FIELD_CONNECTION, HTTPConstants.CONNECTION_FIELD_VALUE_CLOSE);
		return response;
	}

	@Override
	public HTTPResponse post(HTTPRequest request, Map<String, String> headers, Map<String, String> parameters) {
		HTTPResponse response = new HTTPResponse("REPLY " + END_POINT + " | POST");
		response.setStatus(HTTPConstants.HTTP_STATUS_OK);
		response.addHeaderField(HTTPConstants.FIELD_CONNECTION, HTTPConstants.CONNECTION_FIELD_VALUE_CLOSE);
		return response;
	}

	@Override
	public HTTPResponse get(HTTPRequest request, Map<String, String> headers, Map<String, String> parameters) {
		HTTPResponse response = new HTTPResponse("REPLY " + END_POINT + " | GET");
		response.setStatus(HTTPConstants.HTTP_STATUS_OK);
		response.addHeaderField(HTTPConstants.FIELD_CONNECTION, HTTPConstants.CONNECTION_FIELD_VALUE_CLOSE);
		return response;
	}

	@Override
	public HTTPResponse put(HTTPRequest request, Map<String, String> headers, Map<String, String> parameters) {
		HTTPResponse response = new HTTPResponse("REPLY " + END_POINT + " | PUT");
		response.setStatus(HTTPConstants.HTTP_STATUS_OK);
		response.addHeaderField(HTTPConstants.FIELD_CONNECTION, HTTPConstants.CONNECTION_FIELD_VALUE_CLOSE);
		return response;
	}

}
