package com.github.matschieu.mailextractor;

/**
* @author Matschieu
*/
public class FileNotFoundException extends Exception {

	private static final long serialVersionUID = 2524299380058179183L;

	private String message;

	public FileNotFoundException() { message = "Erreur : impossible d'ouvrir le fichier"; }
	public FileNotFoundException(String file) { message = "Erreur : impossible d'ouvrir le fichier " + file; }

	@Override
	public String toString() { return message; }

}