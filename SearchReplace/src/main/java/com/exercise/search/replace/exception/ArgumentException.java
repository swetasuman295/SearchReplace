package com.exercise.search.replace.exception;

/**
 * @Description: Arguments Exception class is called when the Command line arguments are not in the format that is expected 
 *
 */
public class ArgumentException extends Exception {

	private static final long serialVersionUID = 216780640976777535L;

	/**
	 * @param errorMessage
	 */
	public ArgumentException(String errorMessage) {
		super(errorMessage);
	}
}