package com.github.matschieu.calculator.listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.github.matschieu.calculator.components.Calculator;

/**
 * @author Matschieu
 */
public class MenuListener implements ActionListener {

	private Calculator calc;
	private JMenuItem[] file;
	private JMenuItem[] edit;
	private JMenuItem[] view;
	private JMenuItem[] help;

	public MenuListener(Calculator calc, JMenuItem[] file, JMenuItem[] edit, JMenuItem[] view, JMenuItem[] help) {
		this.calc = calc;
		this.file = file;
		this.edit = edit;
		this.view = view;
		this.help = help;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == file[0]) calc.exit();
		else if (e.getSource() == edit[0]) { calc.copy(); }
		else if (e.getSource() == edit[1]) { calc.paste(); }
		else if (e.getSource() == edit[2]) { calc.insertConstantValue(Math.PI); }
		else if (e.getSource() == view[0]) calc.applyJavaSkin();
		else if (e.getSource() == view[1]) calc.applySystemSkin();
		else if (e.getSource() == help[0])	calc.displayInfo();
	}

}
