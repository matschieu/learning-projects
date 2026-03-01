package com.github.matschieu.calculator.listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.github.matschieu.calculator.components.Calculator;

/**
 * @author Matschieu
 */
public class ButtonListener implements ActionListener {

	private Calculator calc;
	private JButton[] numbers;
	private JButton[] operators;

	public ButtonListener(Calculator calc, JButton[] numbers, JButton[] operators) {
		this.calc = calc;
		this.numbers = numbers;
		this.operators = operators;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < numbers.length; i++) {
			if (e.getSource() == numbers[10]) {
				calc.toReal();
				break;
			}
			else if (e.getSource() == numbers[11]) {
				calc.inverse();
				break;
			}
			else if (e.getSource() == numbers[i]) {
				calc.setNumericScreen(numbers[i].getText());
				break;
			}
		}
		for(int i = 0; i < operators.length; i++) {
			if (e.getSource() == operators[4]) {
				calc.resultCalculate();
				break;
			}
			else if (e.getSource() == operators[6]) {
				calc.setOperatorScreen(operators[6].getText());
				calc.resultCalculate();
				break;
			}
			else if (e.getSource() == operators[7]) {
				calc.clearScreen();
				break;
			}
			else if (e.getSource() == operators[i]) {
				calc.setOperatorScreen(operators[i].getText());
				break;
			}
		}
	}

}
