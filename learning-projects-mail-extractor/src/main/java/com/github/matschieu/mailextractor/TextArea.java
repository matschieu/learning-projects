package com.github.matschieu.mailextractor;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
* @author Matschieu
*/
public class TextArea extends JPanel {

	private static final long serialVersionUID = 3523288681244282289L;

	private JTextArea textArea;

	public TextArea() { this(10, 10); }
	public TextArea(int rows, int cols) {
		textArea = new JTextArea(rows, cols);
		textArea.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);
		add(new JLabel(" "), BorderLayout.SOUTH);
	}

	public String getText() { return textArea.getText(); }
	public void setText(String str) { textArea.setText(str); }

}
