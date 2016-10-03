/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver.socket;

import java.io.IOException;
import java.net.ServerSocket;

import ej.hoka.net.IServerSocketConnection;
import ej.hoka.net.ISocketConnection;

/**
 * IS2T-API J2SE {@link java.net.ServerSocket} connection
 */
public class ServerSocketConnection implements IServerSocketConnection {

	protected ServerSocket server;

	/**
	 * Instantiates an empty connection. When port is set, connection will be opened.
	 *
	 * @see #setPort(int)
	 */
	public ServerSocketConnection() {
		// for service loader usage
		// combined to #setPort
	}

	/**
	 * Instantiates a new connection wrapper on the given port.
	 */
	public ServerSocketConnection(int port) throws IOException {
		this.setPort(port);
	}

	@Override
	public ISocketConnection accept() throws IOException {
		return new SocketConnection(this.server.accept());
	}

	@Override
	public void close() throws IOException {
		this.server.close();
	}

	@Override
	public String getAddress() throws IOException {
		try {
			return this.server.getInetAddress().getHostAddress();
		} catch (NullPointerException e) {
			throw new IOException();
		}
	}

	@Override
	public int getPort() throws IOException {
		return this.server.getLocalPort();
	}

	@Override
	public IServerSocketConnection setPort(int port) throws IOException {
		if (this.server != null) {
			this.server.close();
		}
		this.server = new ServerSocket(port);
		return this;
	}

}
