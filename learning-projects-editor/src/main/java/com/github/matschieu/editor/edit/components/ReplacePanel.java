package com.github.matschieu.editor.edit.components;


import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Matschieu
 */
public class ReplacePanel extends JPanel {

	private static final long serialVersionUID = -9104000867468183424L;

	private JTextField word1;
	private JTextField word2;

	public ReplacePanel() {
		word1 = new JTextField();
		word2 = new JTextField();
		setLayout(new GridLayout(2,2));
		add(new JLabel("Recherche "));
		add(word1);
		add(new JLabel("Remplacer par "));
		add(word2);
	}

	public String getSearch() { return word1.getText(); }

	public String getReplace() { return word2.getText(); }

}
