package com.github.matschieu.calculator.components;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.github.matschieu.calculator.listeners.MenuListener;

/**
 * @author Matschieu
 */
public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = -7327164510399662156L;

	private JMenu[] menu;
	private JMenuItem[] file;
	private JMenuItem[] edit;
	private JMenuItem[] view;
	private JMenuItem[] help;
	private MenuListener menuListener;

	public MenuBar(Calculator calc, Screen screen) {
		this.menu = new JMenu[4];
		menu[0] = new JMenu("Fichier");
		menu[1] = new JMenu("Edition");
		menu[2] = new JMenu("Affichage");
		menu[3] = new JMenu("?");
		this.file = new JMenuItem[1];
		file[0] = new JMenuItem("Quitter");
		this.edit = new JMenuItem[3];
		edit[0] = new JMenuItem("Copier");
		edit[1] = new JMenuItem("Coller");
		edit[1].setEnabled(false);
		edit[2] = new JMenuItem("Valeur de PI");
		this.view = new JMenuItem[2];
		view[0] = new JMenuItem("Style métal");
		view[1] = new JMenuItem("Style système");
		this.help = new JMenuItem[1];
		help[0] = new JMenuItem("A propos de M-Calc");
		this.menuListener = new MenuListener(calc, file, edit, view, help);
		for (int i = 0; i < file.length; i++) {
			file[i].addActionListener(menuListener);
			menu[0].add(file[i]);
		}
		for (int i = 0; i < edit.length; i++) {
			edit[i].addActionListener(menuListener);
			menu[1].add(edit[i]);
			if (i == 1) menu[1].addSeparator();
		}
		for (int i = 0; i < view.length; i++) {
			view[i].addActionListener(menuListener);
			menu[2].add(view[i]);
		}
		for (int i = 0; i < help.length; i++) {
			help[i].addActionListener(menuListener);
			menu[3].add(help[i]);
		}
		for (int i = 0; i < menu.length; i++) add(menu[i]);
	}

	public void setPasteEnable(boolean b) { edit[1].setEnabled(b);}

}
