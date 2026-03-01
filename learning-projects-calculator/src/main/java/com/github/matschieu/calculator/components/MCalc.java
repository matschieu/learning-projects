package com.github.matschieu.calculator.components;


import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * @author Matschieu
 */
public class MCalc implements Calculator {

	private static final String APPLICATION_NAME = "M-CALC";
	private static final String APPLICATION_VERSION = "2.5.1";

	private MenuBar menuBar;
	private Screen screen;
	private Keyboard keyboard;
	private StateBar stateBar;
	private Frame frame;
	private boolean equals = false;

	public MCalc() {
		this.screen = new Screen();
		this.frame = new Frame(APPLICATION_NAME);
		this.menuBar = new MenuBar(this, screen);
		this.keyboard = new Keyboard(this);
		this.stateBar = new StateBar();
		frame.setLayout(new BorderLayout());
		frame.setJMenuBar(menuBar);
		frame.add(new JLabel("  "), BorderLayout.WEST);
		JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			p.add(screen);
			p.add(new JLabel(" "));
			p.add(keyboard);
		frame.add(p, BorderLayout.CENTER);
		frame.add(new JLabel("  "), BorderLayout.EAST);
		frame.add(stateBar, BorderLayout.SOUTH);
		frame.pack();
	}

	@Override
	public void setNumericScreen(String numb) {
		if (!equals) screen.appendCurrentScreen(numb);
		else {
			screen.setCurrentScreen(numb);
			equals = false;
		}
	}

	@Override
	public void setOperatorScreen(String op) { screen.setOperator(op); }

	@Override
	public void resultCalculate() {
		String op = screen.getOperator();
		if (!screen.getScreen2().equals(Screen.EMPTY) && !op.equals(Screen.EMPTY)) {
			double numb1 = Double.parseDouble(screen.getScreen1());
			double numb2 = Double.parseDouble(screen.getScreen2());
			double result = 0;
			if (op.equals("+")) result = numb1 + numb2;
			else if (op.equals("-")) result = numb1 - numb2;
			else if (op.equals("*")) result = numb1 * numb2;
			else if (op.equals("/")) result = numb1 / numb2;
			else if (op.equals("^")) result = Math.pow(numb1, numb2);
			screen.clear();
			screen.setCurrentScreen("" + result);
			equals = true;
		}
		else if (screen.getScreen2().equals(Screen.EMPTY) && op.equals("�")) {
			double numb1 = Double.parseDouble(screen.getScreen1());
			double result = numb1 * numb1;
			screen.clear();
			screen.setCurrentScreen("" + result);
			equals = true;
		}
	}

	@Override
	public void clearScreen() { screen.clear(); }

	@Override
	public void inverse() {
		String str = screen.getCurrentScreen();
		if (Double.parseDouble(str) > 0) str = "-" + str;
		else if (Double.parseDouble(str) < 0) str = str.substring(1);
		screen.setCurrentScreen(str);
	}

	@Override
	public void toReal() {
		boolean isDecimal = false;
		String str = screen.getCurrentScreen();
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == '.') {
				isDecimal = true;
				break;
			}
		if(!isDecimal) {
			if (str.equals("")) str = str + "0.";
			else str = str + ".";
		}
		screen.setCurrentScreen(str);
	}

	@Override
	public void copy() {
		screen.copyCurrentNumber();
		menuBar.setPasteEnable(true);
	}

	@Override
	public void paste() { screen.pasteCopiedNumber(); }

	@Override
	public void insertConstantValue(double value) { screen.setCurrentScreen("" + value); }

	@Override
	public void displayInfo() {
		JOptionPane.showMessageDialog(null, toString(), APPLICATION_NAME, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getClassLoader().getResource("icons/ico_calc.png")));
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("");
		str.append(APPLICATION_NAME + " " + APPLICATION_VERSION + "\n");
		str.append("Developped with Java\n");
		str.append("(c) Matschieu, 2007\n");
		return str.toString();
	}

	@Override
	public void exit() { System.exit(0); }

	@Override
	public void applyJavaSkin() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(frame);
		}
		catch(Exception e) { }
	}
	@Override
	public void applySystemSkin() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(frame);
		}
		catch(Exception e) { }
	}

}
