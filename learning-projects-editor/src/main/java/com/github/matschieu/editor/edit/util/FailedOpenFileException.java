package com.github.matschieu.editor.edit.util;

/**
 * @author Matschieu
 */
public class FailedOpenFileException extends Exception {

	private static final long serialVersionUID = -4744263187783452113L;

	private String message;

	public FailedOpenFileException(String message) { this.message = message; }
	public FailedOpenFileException() { this("FailedOpenFileException"); }

	@Override
	public String toString() { return message; }

}
