package com.github.matschieu.editor.edit.components;


import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 * @author Matschieu
 */
public class Button extends JButton {

	private static final long serialVersionUID = 8347821816386549214L;

	public Button(String label, String iconPath, String infoBull) {
		super(label, new ImageIcon(Button.class.getClassLoader().getResource(iconPath)));
		if (!infoBull.equals("")) setToolTipText(infoBull);
	}

	public Button(String label) { this(label, "", ""); }

	public Button(String label, String iconPath) { this(label, iconPath, ""); }

	public void setDecoration() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1));
		setBackground(new Color(0, 0, 0));
		setForeground(new Color(0, 0, 0));
	}

}
