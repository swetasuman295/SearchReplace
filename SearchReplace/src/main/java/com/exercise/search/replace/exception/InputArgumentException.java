package com.exercise.search.replace.exception;
/**
 * @Description: Input Argument Exception class is called when the Input provided is not Supported by the application.
 *
 */
public class InputArgumentException extends Exception {
	private static final long serialVersionUID = 216780640976777535L;

	/**
	 * @param errorMessage
	 */
	public InputArgumentException(String errorMessage) {
		super(errorMessage);
	}
}