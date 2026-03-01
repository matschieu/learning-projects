package com.github.matschieu.editor.edit.util;

/**
 * @author Matschieu
 */
public class FailedReadFileException extends Exception {

	private static final long serialVersionUID = -4831708159133152399L;

	private String message;

	public FailedReadFileException(String message) { this.message = message; }
	public FailedReadFileException() { this("FailedReadFileException"); }

	@Override
	public String toString() { return message; }

}
