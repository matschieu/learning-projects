package com.github.matschieu.editor.edit.components;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.github.matschieu.editor.edit.listeners.MenuListener;

/**
 * @author Matschieu
 */
public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 5003637306213822728L;

	private JMenu[] menu;
	private JMenuItem[] file;
	private JMenuItem[] edit;
	private JMenuItem[] view;
	private JMenuItem[] help;

	public MenuBar(Editor editor) {
		menu = new JMenu[4];
		menu[0] = new JMenu("Fichier");
		menu[1] = new JMenu("Edition");
		menu[2] = new JMenu("Affichage");
		menu[3] = new JMenu("?");
		this.file = new JMenuItem[5];
		file[0] = new JMenuItem("Nouveau");
		file[1] = new JMenuItem("Ouvrir");
		file[2] = new JMenuItem("Enregistrer sous...");
		file[3] = new JMenuItem("Enregistrer");
		file[4] = new JMenuItem("Quitter");
		this.edit = new JMenuItem[3];
		edit[0] = new JMenuItem("Copier");
		edit[1] = new JMenuItem("Coller");
		edit[2] = new JMenuItem("Remplacer");
		this.view = new JMenuItem[3];
		view[0] = new JMenuItem("Style Métal");
		view[1] = new JMenuItem("Style Système");
		view[2] = new JMenuItem("Calculatrice");
		this.help = new JMenuItem[1];
		help[0] = new JMenuItem("A propos de M-Edit");
		MenuListener listener = new MenuListener(editor, file, edit, view, help);
		for(int i = 0; i < file.length; i++) {
			file[i].addActionListener(listener);
			menu[0].add(file[i]);
			if (i == 3) menu[0].addSeparator();
		}
		for(int i = 0; i < edit.length; i++) {
			edit[i].addActionListener(listener);
			menu[1].add(edit[i]);
			if (i == 1) menu[1].addSeparator();
		}
		for(int i = 0; i < view.length; i++) {
			view[i].addActionListener(listener);
			menu[2].add(view[i]);
			if (i == 1) menu[2].addSeparator();
		}
		for(int i = 0; i < help.length; i++) {
			help[i].addActionListener(listener);
			menu[3].add(help[i]);
		}
		for(int i = 0; i < menu.length; i++) {
			add(menu[i]);
		}
	}

}
