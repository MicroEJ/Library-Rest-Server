/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import ej.hoka.net.ISocketConnection;

/**
 * IS2T-API J2SE {@link java.net.Socket} connection
 */
public class SocketConnection implements ISocketConnection {

	private final Socket socket;

	/**
	 * IS2T-API Create a new connection wrapper on the given {@link Socket}
	 */
	public SocketConnection(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void close() throws IOException {
		this.socket.close();
	}

	@Override
	public String getAddress() throws IOException {
		try {
			return this.socket.getInetAddress().getHostAddress();
		} catch (NullPointerException e) {
			throw new IOException(e);
		}
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return this.socket.getInputStream();
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return this.socket.getOutputStream();
	}

}
