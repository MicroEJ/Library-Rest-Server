/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver.socket;

import java.io.IOException;
import java.net.Socket;

import ej.hoka.net.IClientSocketConnection;

/**
 * A client socket connection implementation based on Java standard sockets.
 */
public class ClientSocketConnection implements IClientSocketConnection {

	private Socket client;

	/**
	 * Instantiates a new client socket connection. Underlying socket is immediately created.
	 *
	 * @param host
	 *            the host, or {@code null} for loopback address.
	 * @param port
	 *            the port number.
	 * @throws IOException
	 *             if socket cannot be created.
	 */
	public ClientSocketConnection(String host, int port) throws IOException {
		this.client = new Socket(host, port);
	}

	@Override
	public void close() throws IOException {
		this.client.close();
	}

	@Override
	public SocketConnection connect(String uri, int port) throws IOException {
		if (this.client != null) {
			this.client.close();
		}
		this.client = new Socket(uri, port);
		return new SocketConnection(this.client);
	}

	@Override
	public String getAddress() throws IOException {
		return this.client.getInetAddress().toString();
	}

	@Override
	public int getPort() throws IOException {
		return this.client.getLocalPort();
	}

}
