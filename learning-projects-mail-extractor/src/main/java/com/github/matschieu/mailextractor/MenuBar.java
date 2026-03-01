package com.github.matschieu.mailextractor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
* @author Matschieu
*/
public class MenuBar extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = 7113026813362076313L;

	private JMenu[] menu;
	private JMenuItem[] file;
	private JMenuItem[] help;
	private MExtractor mext;

	public MenuBar(MExtractor me) {
		mext = me;
		menu = new JMenu[2];
		menu[0] = new JMenu("Fichier");
		menu[1] = new JMenu("?");
		file = new JMenuItem[5];
		file[0] = new JMenuItem("Nouveau");
		file[1] = new JMenuItem("Ouvrir");
		file[2] = new JMenuItem("Enregistrer");
		file[3] = new JMenuItem("Extraire");
		file[4] = new JMenuItem("Quitter");
		help = new JMenuItem[1];
		help[0] = new JMenuItem("A propos de...");
		for(int i = 0; i < file.length; i++) {
			file[i].addActionListener(this);
			if (i == 3 || i == 4) menu[0].addSeparator();
			menu[0].add(file[i]);
		}
		for(int i = 0; i < help.length; i++) {
			help[i].addActionListener(this);
			menu[1].add(help[i]);
		}
		for(int i = 0; i < menu.length; i++) add(menu[i]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == file[0]) mext.clear();
		else if (e.getSource() == file[1]) mext.open();
		else if (e.getSource() == file[2]) mext.save();
		else if (e.getSource() == file[3]) mext.extract();
		else if (e.getSource() == file[4]) mext.exit();
		else if (e.getSource() == help[0]) mext.displayInfo();
	}

}
