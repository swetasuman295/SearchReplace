package com.exercise.search.replace.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: Arguments Exception class is called when the Command line arguments are not in the format that is expected 
 *
 */
public class ArgumentException extends Exception {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArgumentException.class);
	private static final long serialVersionUID = 216780640976777535L;

	/**
	 * @param errorMessage
	 */
	public ArgumentException(String errorMessage) {
		super(errorMessage);
	}
}