/*
* Java
*
* Copyright 2017 IS2T. All rights reserved.
* Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
*/
package com.microej.example;

import java.io.IOException;

import ej.restserver.RestServer;

public class RestServerExample {
	public static void main(String[] args) {

		RestServer restServer;
		try {
			restServer = new RestServer(8080, 10, 10);
			restServer.addEndpoint(new HelloEndPoint());
			restServer.addRequestResolver(new DumpRequestHandler());
			restServer.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
