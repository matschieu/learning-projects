package com.github.matschieu.editor.edit.components;


import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Matschieu
 */
class Label extends JPanel {

	private static final long serialVersionUID = -630964105019633278L;

	private static final String EMPTY =  " ";

	private JLabel label;

	public Label() {
		this.label = new JLabel(EMPTY);
		setLayout(new GridLayout(1, 1));
		add(label);
	}

	public void setLabel(String str) { label.setText(str); }
	public String getLabel() { return label.getText(); }
	public void clearLabel() { label.setText(EMPTY); }

}
