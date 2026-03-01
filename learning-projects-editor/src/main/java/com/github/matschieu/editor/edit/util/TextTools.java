package com.github.matschieu.editor.edit.util;

/**
 * @author Matschieu
 */
public class TextTools {

	public static String replace(String str, String occur, String newWord, char separator) {
		StringBuffer strbuf = new StringBuffer();
		StringBuffer word = new StringBuffer("");
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c < 97 && c > 32 || c == separator) {
				if (word.toString().equals(occur)) word = new StringBuffer(newWord);
				strbuf.append(word.toString() + c);
				word = new StringBuffer("");
			}
			else word.append("" + str.charAt(i));
		}
		if (!word.toString().equals("")) strbuf.append(word.toString());
		return strbuf.toString();
	}
	public static String replace(String str, String occur, String newWord) {
		return replace(str, occur, newWord, ' ');
	}

}
