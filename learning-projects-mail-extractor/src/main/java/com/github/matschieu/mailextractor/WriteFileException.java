package com.github.matschieu.mailextractor;

/**
* @author Matschieu
*/
public class WriteFileException extends Exception {

	private static final long serialVersionUID = 8989953313410839009L;

	private String message;

	public WriteFileException() { message = "Erreur : impossible d'écrire dans le fichier"; }
	public WriteFileException(String file) { message = "Erreur : impossible d'écrire dans le fichier" + file; }

	@Override
	public String toString() { return message; }

}
