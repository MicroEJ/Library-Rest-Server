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
 * A socket connection implementation based on Java standard sockets.
 */
public class SocketConnection implements ISocketConnection {

	private final Socket socket;

	/**
	 * Instantiates a new socket connection that wraps given Java socket.
	 *
	 * @param socket
	 *            the underlying socket.
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
