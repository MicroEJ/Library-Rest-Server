/*
* Java
*
* Copyright 2017-2018 IS2T. All rights reserved.
* For demonstration purpose only.
* IS2T PROPRIETARY. Use is subject to license terms.
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
