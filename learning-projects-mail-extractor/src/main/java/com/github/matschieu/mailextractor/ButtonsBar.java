package com.github.matschieu.mailextractor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
* @author Matschieu
*/
public class ButtonsBar extends JPanel implements ActionListener {

	private static final long serialVersionUID = 8075042657435622181L;

	private static final String IMAGES_PATH = "icons/";
	private static final String IMAGES_EXTENSION = ".png";

	private JButton buttons[];
	private MExtractor mext;

	private ImageIcon getImageIcon(String filename) {
		URL fileLoc = this.getClass().getClassLoader().getResource(filename);
		if (fileLoc == null) {
			return new ImageIcon(filename);
		}
		return new ImageIcon(fileLoc);
	}

	public ButtonsBar(MExtractor me) {
		mext = me;
		buttons = new JButton[6];
		buttons[0] = new JButton(this.getImageIcon(IMAGES_PATH + "new_ico" + IMAGES_EXTENSION));
		buttons[0].setToolTipText("Nouveau");
		buttons[1] = new JButton(this.getImageIcon(IMAGES_PATH + "open_ico" + IMAGES_EXTENSION));
		buttons[1].setToolTipText("Ouvrir");
		buttons[2] = new JButton(this.getImageIcon(IMAGES_PATH + "save_ico" + IMAGES_EXTENSION));
		buttons[2].setToolTipText("Enregistrer");
		buttons[3] = new JButton(this.getImageIcon(IMAGES_PATH + "extract_ico" + IMAGES_EXTENSION));
		buttons[3].setToolTipText("Extraire");
		buttons[4] = new JButton(this.getImageIcon(IMAGES_PATH + "exit_ico" + IMAGES_EXTENSION));
		buttons[4].setToolTipText("Quitter");
		buttons[5] = new JButton(this.getImageIcon(IMAGES_PATH + "info_ico" + IMAGES_EXTENSION));
		buttons[5].setToolTipText("A propos...");
		setLayout(new GridLayout(1, 7));
		JToolBar tools = new JToolBar();
		tools.setFloatable(false);
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
			tools.add(buttons[i]);
			if (i == 2 || i == 3 || i == 4) tools.addSeparator();
		}
		add(tools);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons[0]) mext.clear();
		else if (e.getSource() == buttons[1]) mext.open();
		else if (e.getSource() == buttons[2]) mext.save();
		else if (e.getSource() == buttons[3]) mext.extract();
		else if (e.getSource() == buttons[4]) mext.exit();
		else if (e.getSource() == buttons[5]) mext.displayInfo();
	}

}
