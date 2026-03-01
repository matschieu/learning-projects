package com.github.matschieu.editor.edit.components;


import java.awt.Color;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * @author Matschieu
 */
public class Report extends JPanel {

	private static final long serialVersionUID = -2031813650275437507L;

	private static final String EOL = System.getProperty("line.separator");

	private JTextArea textArea;

	public Report() {
		setLayout(new GridLayout(1,1));
		this.textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setRows(10);
		textArea.setEditable(false);
		textArea.setForeground(new Color(200, 0, 0));
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setAutoscrolls(true);
		add(scrollPane);
	}

	public void clear() { textArea.setText(""); }
	public String getText() { return textArea.getText(); }
	public void setText(String str) {
		textArea.append((new Date()).toString() + " " + str + EOL);
	}

}
