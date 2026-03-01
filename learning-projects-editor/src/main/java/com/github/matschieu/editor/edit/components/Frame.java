package com.github.matschieu.editor.edit.components;


import javax.swing.JFrame;

/**
 * @author Matschieu
 */
public class Frame extends JFrame {

	private static final long serialVersionUID = -8156014067817878300L;

	public Frame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
