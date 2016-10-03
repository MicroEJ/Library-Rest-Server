/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.restserver.socket;

import java.io.IOException;

import ej.hoka.net.IClientSocketConnection;
import ej.hoka.net.IClientSocketConnectionFactory;

public class ClientSocketConnectionFactory implements IClientSocketConnectionFactory {

	@Override
	public IClientSocketConnection getNewClientSocketConnection(String host, int port) throws IOException {
		return new ClientSocketConnection(host, port);
	}

}
