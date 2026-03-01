package com.github.matschieu.editor.edit.util;

/**
 * @author Matschieu
 */
public class FailedWriteFileException extends Exception {

	private static final long serialVersionUID = 6272293130852605267L;

	private String message;

	public FailedWriteFileException(String message) { this.message = message; }
	public FailedWriteFileException() { this("FailedWriteFileException"); }

	@Override
	public String toString() { return message; }

}
