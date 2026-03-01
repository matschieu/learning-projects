package com.github.matschieu.mailextractor;

/**
* @author Matschieu
*/
public class ReadFileException extends Exception {

	private static final long serialVersionUID = 6840337630994422022L;

	private String message;

	public ReadFileException() { message = "Erreur : impossible de lire le fichier"; }
	public ReadFileException(String file) { message = "Erreur : impossible de lire le fichier " + file; }

	@Override
	public String toString() { return message; }

}
