/*
* Java
*
* Copyright 2017 IS2T. All rights reserved.
* Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
*/
package com.microej.example;

import java.util.Map.Entry;

import ej.hoka.http.HTTPRequest;
import ej.hoka.http.HTTPResponse;
import ej.restserver.RequestHandler;
import ej.restserver.RestServer;

public class DumpRequestHandler implements RequestHandler {

	@Override
	public HTTPResponse answer(RestServer server, HTTPRequest request) {
		dumpMessage(request);
		return HTTPResponse.RESPONSE_OK;
	}

	private void dumpMessage(HTTPRequest request) {
		System.out.println(" ****** HTTP Request ******");
		System.out.println(" * URI : " + request.getURI());
		System.out.println(" * VERSION : " + request.getVersion());
		if (request.getParameters().size() > 0) {
			System.out.println(" * PARAMS : ");
			for (Entry<String, String> entry : request.getParameters().entrySet()) {
				System.out.println("      * " + entry.getKey() + " : " + entry.getValue());
			}
		}
		if (request.getHeader().size() > 0) {
			System.out.println(" * HEADERS : ");
			for (Entry<String, String> entry : request.getHeader().entrySet()) {
				System.out.println("      * " + entry.getKey() + " : " + entry.getValue());
			}
		}
		System.out.println(" ****** ");
	}
}
