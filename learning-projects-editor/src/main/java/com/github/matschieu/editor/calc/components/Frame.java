package com.github.matschieu.editor.calc.components;


import javax.swing.JFrame;

/**
 * @author Matschieu
 */
public class Frame extends JFrame {

	private static final long serialVersionUID = 2944094968576779589L;

	public Frame(String title) {
		super(title);
		setResizable(false);
		setLocation((int)(Math.random() * 700), (int)(Math.random() * 450));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
