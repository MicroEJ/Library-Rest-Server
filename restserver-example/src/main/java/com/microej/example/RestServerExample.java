/*
 * Java
 *
 * Copyright 2017-2018 IS2T. All rights reserved.
 * For demonstration purpose only.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package com.microej.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import ej.hoka.http.body.StringBodyParserFactory;
import ej.restserver.RestServer;
import ej.restserver.endpoint.GzipResourceEndpoint;
import ej.restserver.endpoint.ResourceRestEndpoint;

public class RestServerExample {
	private static final String SLASH = "/";

	public static void main(String[] args) {

		RestServer restServer;
		try {
			restServer = new RestServer(8080, 10, 10);
			restServer.addEndpoint(new HelloEndPoint());

			try (InputStream resourceFile = RestServerExample.class.getResourceAsStream("/html/html.resources.list")) {
				createStaticEndpoints(restServer, resourceFile, "/index.html", "/html/");
			}
			restServer.addRequestResolver(new DumpRequestHandler());
			restServer.setBodyParserFactory(new StringBodyParserFactory());
			restServer.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createStaticEndpoints(RestServer server, InputStream resourceFile, String homePage,
			String baseResourceDir) throws IOException {
		Properties filesProperties = new Properties();
		filesProperties.load(resourceFile);
		Set<String> files = filesProperties.stringPropertyNames();
		for (String filePath : files) {
			filePath = filePath.trim();
			String endpoint = filePath;
			if (filePath.startsWith(baseResourceDir)) {
				endpoint = SLASH + filePath.substring(baseResourceDir.length());
			}
			if (filePath.endsWith(GzipResourceEndpoint.GZIP_FILE_EXTENSION)) {
				endpoint = endpoint.substring(0, endpoint.length() - GzipResourceEndpoint.GZIP_FILE_EXTENSION.length());
				if (endpoint.equals(homePage)) {
					server.addEndpoint(new GzipResourceEndpoint(SLASH, filePath));
				}
				server.addEndpoint(new GzipResourceEndpoint(endpoint, filePath));
			} else {
				if (endpoint.equals(homePage)) {
					server.addEndpoint(new ResourceRestEndpoint(SLASH, filePath));
				}
				server.addEndpoint(new ResourceRestEndpoint(endpoint, filePath));
			}
		}
	}
}
