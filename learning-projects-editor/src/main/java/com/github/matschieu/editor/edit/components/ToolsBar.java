package com.github.matschieu.editor.edit.components;


import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.github.matschieu.editor.edit.listeners.ButtonListener;

/**
 * @author Matschieu
 */
public class ToolsBar extends JPanel {

	private static final long serialVersionUID = -5666861347623303699L;

	private static final String ICO_PATH = "icons";

	private Button[] buttons;

	public ToolsBar(Editor editor) {
		this.buttons = new Button[9];
		ButtonListener listener = new ButtonListener(editor, buttons);
		buttons[0] = new Button("", ICO_PATH + "/ico_new.png", "Nouveau");
		buttons[1] = new Button("", ICO_PATH + "/ico_open.png", "Ouvrir");
		buttons[2] = new Button("", ICO_PATH + "/ico_save_as.png", "Enregistrer sous...");
		buttons[3] = new Button("", ICO_PATH + "/ico_save.png", "Enregistrer");
		buttons[4] = new Button("", ICO_PATH + "/ico_copy.png", "Copier");
		buttons[5] = new Button("", ICO_PATH + "/ico_paste.png", "Coller");
		buttons[6] = new Button("", ICO_PATH + "/ico_replace.png", "Rempacer");
		buttons[7] = new Button("", ICO_PATH + "/ico_calc.png", "Calculatrice");
		buttons[8] = new Button("", ICO_PATH + "/ico_ball.png", "A propos de M-Edit");
		setLayout(new GridLayout(1, 7));
		JToolBar tools = new JToolBar();
		tools.setFloatable(false);
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(listener);
			tools.add(buttons[i]);
			if (i == 3 || i == 6 || i == 7) tools.addSeparator();
		}
		add(tools);
	}

}
