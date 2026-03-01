package com.github.matschieu.mailextractor;

/**
* @author Matschieu
*/
public class Extractor {

	private final char SEPARATOR1 = ' ';
	private final char SEPARATOR2 = '\n';
	private final char SEPARATOR3 = '\t';
	private final char SEARCHEDCHARACTER = '@';

	public Extractor() { }

	public String extract(String str) {
		boolean isMailAdress = false;
		StringBuffer tempWord = new StringBuffer("");
		StringBuffer mailList = new StringBuffer("");
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) != SEPARATOR1 && str.charAt(i) != SEPARATOR2 && str.charAt(i) != SEPARATOR3) {
				Character c = Character.valueOf(str.charAt(i));
				tempWord.append(c.toString());
			}
			else {
				for (int j = 0; j < tempWord.length(); j++)
					if (tempWord.charAt(j) == SEARCHEDCHARACTER) {
						isMailAdress = true;
						break;
					}
				if (isMailAdress) {
					if (mailList.toString().equals("")) mailList.append(tempWord.toString());
					else mailList.append(", " + tempWord.toString());
				}
				tempWord = new StringBuffer("");
				isMailAdress = false;
			}
		return mailList.toString();
	}

}
