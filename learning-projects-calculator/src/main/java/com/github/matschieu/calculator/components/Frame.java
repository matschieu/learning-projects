package com.github.matschieu.calculator.components;


import javax.swing.JFrame;

/**
 * @author Matschieu
 */
public class Frame extends JFrame {

	private static final long serialVersionUID = 5759543788988027271L;

	public Frame(String title) {
		super(title);
		setResizable(false);
		setLocation((int)(Math.random() * 700), (int)(Math.random() * 450));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
