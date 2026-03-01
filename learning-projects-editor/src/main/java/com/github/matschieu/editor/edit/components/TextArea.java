package com.github.matschieu.editor.edit.components;


import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * @author Matschieu
 */
public class TextArea extends JPanel {

	private static final long serialVersionUID = -2534087812329882484L;

	private static final String EOL = System.getProperty("line.separator");

	private JTextArea textArea;

	public TextArea(int rows, int cols) {
		setLayout(new GridLayout(1,1));
		this.textArea = new JTextArea(rows, cols);
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setAutoscrolls(true);
		add(scrollPane);
	}

	public void clear() { textArea.setText(""); }
	public void setText(String str) { textArea.append(str + EOL); }
	public String getText() { return textArea.getText(); }

}
