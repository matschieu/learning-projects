package com.github.matschieu.editor.calc.components;


import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author Matschieu
 */
public class Screen extends JPanel {

	private static final long serialVersionUID = -2262941309451319041L;

	private static final int MAX_SCREEN_NUMBER_LENGTH = 34;

	public static final String EMPTY = " ";

	private JLabel screen1;
	private JLabel screen2;
	private JLabel operator;
	private JLabel currentScreen;
	private String buffer;

	public Screen() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.screen1 = new JLabel("0");
		this.screen2 = new JLabel(EMPTY);
		this.operator = new JLabel(EMPTY);
		this.currentScreen = screen1;
		this.buffer = "";
		JPanel panel1 = new JPanel();
			panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
			panel1.add(screen1);
		JPanel panel2 = new JPanel();
			panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
			panel2.add(operator);
		JPanel panel3 = new JPanel();
			panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
			panel3.add(screen2);
		add(panel1);
		add(panel2);
		add(panel3);
		setBorder(new LineBorder(new Color(0, 0, 0)));
	}

	public void setOperator(String op) {
		operator.setText(op);
		if (currentScreen == screen1 ) changeCurrentScreen();
	}
	public void setCurrentScreen(String numb) { currentScreen.setText(numb); }
	public void appendCurrentScreen(String numb) {
		if (getCurrentScreen().equals("0")) setCurrentScreen("");
		if (getCurrentScreen().length() < MAX_SCREEN_NUMBER_LENGTH) setCurrentScreen(getCurrentScreen() + numb);
	}

	public void clear() {
		screen1.setText("0");
		screen2.setText(EMPTY);
		operator.setText(EMPTY);
		currentScreen = screen1;
	}

	public String getScreen1() { return screen1.getText(); }
	public String getScreen2() { return screen2.getText(); }
	public String getOperator() { return operator.getText(); }
	public String getCurrentScreen() { return currentScreen.getText(); }

	private void changeCurrentScreen() {
		if (currentScreen == screen1) currentScreen = screen2;
		else currentScreen = screen1;
	}

	public void copyCurrentNumber() { buffer = currentScreen.getText(); }
	public void pasteCopiedNumber() { currentScreen.setText(buffer); }

}
