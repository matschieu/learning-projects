package com.github.matschieu.calculator.components;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.matschieu.calculator.listeners.ButtonListener;

/**
 * @author Matschieu
 */
public class Keyboard extends JPanel {

	private static final long serialVersionUID = 2574755222404813165L;

	protected static final int X_SPACE = 5;
	protected static final int Y_SPACE = 5;
	protected static final String SPACE = "  ";

	private JButton[] numbers;
	private JButton[] operators;
	private ButtonListener listener;

	public Keyboard(Calculator calc) {
		this.numbers = new JButton[12];
		this.operators = new JButton[8];
		this.listener = new ButtonListener(calc, numbers, operators);
		JPanel numPanel = new JPanel();
		numPanel.setLayout(new GridLayout(4, 3, X_SPACE, Y_SPACE));
		for(int i = 0; i < numbers.length; i++) {
			if (i < 10) numbers[i] = new JButton(""  + i);
			else if (i == 10) numbers[i] = new JButton(".");
			else numbers[i] = new JButton("+/-");
			numbers[i].addActionListener(listener);
			numPanel.add(numbers[i]);
		}
		JPanel opPanel = new JPanel();
		opPanel.setLayout(new GridLayout(4, 2, X_SPACE, Y_SPACE));
		operators[0] = new JButton("+");
		operators[1] = new JButton("-");
		operators[2] = new JButton("*");
		operators[3] = new JButton("/");
		operators[4] = new JButton("=");
		operators[5] = new JButton("^");
		operators[6] = new JButton("²");
		operators[7] = new JButton("C");
		for(int i = 0; i < operators.length / 2; i++) {
			opPanel.add(operators[i]);
			opPanel.add(operators[i + 4]);
			operators[i].addActionListener(listener);
			operators[i + 4].addActionListener(listener);
		}
		setLayout(new BorderLayout());
		add(numPanel, BorderLayout.WEST);
		add(new JLabel(" "), BorderLayout.CENTER);
		add(opPanel, BorderLayout.EAST);
	}

}
