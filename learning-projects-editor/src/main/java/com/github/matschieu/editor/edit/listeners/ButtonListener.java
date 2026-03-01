package com.github.matschieu.editor.edit.listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.matschieu.editor.calc.components.MCalc;
import com.github.matschieu.editor.edit.components.Button;
import com.github.matschieu.editor.edit.components.Editor;

/**
 * @author Matschieu
 */
public class ButtonListener implements ActionListener {

	private Editor editor;
	private Button[] buttons;

	public ButtonListener(Editor editor, Button[] buttons) {
		this.editor = editor;
		this.buttons = buttons;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttons[0]) editor.newDocument();
		else if (e.getSource() == buttons[1]) editor.openFile();
		else if (e.getSource() == buttons[2]) editor.saveFileAs();
		else if (e.getSource() == buttons[3]) editor.saveFile();
		else if (e.getSource() == buttons[6]) editor.replace();
		else if (e.getSource() == buttons[7]) new MCalc();
		else if (e.getSource() == buttons[buttons.length - 1]) editor.displayInfo();
	}

}
