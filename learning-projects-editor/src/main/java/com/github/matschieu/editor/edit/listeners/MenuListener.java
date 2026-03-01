package com.github.matschieu.editor.edit.listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.github.matschieu.editor.calc.components.MCalc;
import com.github.matschieu.editor.edit.components.Editor;

/**
 * @author Matschieu
 */
public class MenuListener implements ActionListener {

	private Editor editor;
	private JMenuItem[] file;
	private JMenuItem[] edit;
	private JMenuItem[] view;
	private JMenuItem[] help;

	public MenuListener(Editor editor, JMenuItem[] file, JMenuItem[] edit, JMenuItem[] view, JMenuItem[] help) {
		this.editor = editor;
		this.file = file;
		this.edit = edit;
		this.view = view;
		this.help = help;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == file[0]) editor.newDocument();
		else if (e.getSource() == file[1]) editor.openFile();
		else if (e.getSource() == file[2]) editor.saveFileAs();
		else if (e.getSource() == file[3]) editor.saveFile();
		else if (e.getSource() == file[4]) editor.exit();
		else if (e.getSource() == edit[2]) editor.replace();
		else if (e.getSource() == view[0]) editor.applyJavaSkin();
		else if (e.getSource() == view[1]) editor.applySystemSkin();
		else if (e.getSource() == view[2]) new MCalc();
		else if (e.getSource() == help[0]) editor.displayInfo();
	}

}
