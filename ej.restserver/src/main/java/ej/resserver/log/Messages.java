/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.resserver.log;

import ej.restserver.RestServer;
import ej.util.message.MessageBuilder;
import ej.util.message.MessageLogger;
import ej.util.message.basic.BasicMessageBuilder;
import ej.util.message.basic.BasicMessageLogger;

/**
 * Gather the messages.
 */
public final class Messages {
	// ****************//
	// Error messages. //
	// ****************//

	/**
	 * URI is empty.
	 */
	public static final int EMPTY_URI = -1;

	/**
	 * Unknown error.
	 */
	public static final int ERROR_UNKNOWN = -255;

	// ****************//
	// Info messages. //
	// ****************//

	/**
	 * Category message.
	 */
	public static final String CATEGORY = RestServer.class.getSimpleName();

	/**
	 * The message builder.
	 */
	public static final MessageBuilder BUILDER = new BasicMessageBuilder();

	/**
	 * The message logger.
	 */
	public static final MessageLogger LOGGER = new BasicMessageLogger(BUILDER);

	private Messages() {
		// Forbid instantiation
	}
}
