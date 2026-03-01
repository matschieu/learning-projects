package com.github.matschieu.calculator.components;


import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Matschieu
 */
public class StateBar extends JPanel {

	private static final long serialVersionUID = -3876170875117415160L;

	public static final String EMPTY = " ";

	private JLabel message;

	public StateBar() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.message = new JLabel(EMPTY);
		add(message);
	}

	public void setMessage(String str) { message.setText(str); }
	public String getMessage() { return message.getText(); }
	public void clear() { message.setText(EMPTY); }

}
