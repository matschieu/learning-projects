package com.github.matschieu.eval;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Matschieu
 */
public class Eval implements ActionListener {

	private JFrame frame;
	private JButton tbien, bien, bof, nul;
	private int ntbien, nbien, nbof, nnul;

	private ImageIcon getImageIcon(String filename) {
		URL fileLoc = this.getClass().getClassLoader().getResource(filename);
		if (fileLoc == null) {
			return new ImageIcon(filename);
		}
		return new ImageIcon(fileLoc);
	}

	public Eval() {
		frame = new JFrame("Evaluation louveteaux");
		tbien = new JButton(this.getImageIcon("img/tbien.png"));
		bien = new JButton(this.getImageIcon("img/bien.png"));
		bof = new JButton(this.getImageIcon("img/bof.png"));
		nul = new JButton(this.getImageIcon("img/pbien.png"));
		ntbien = nbien = nbof = nnul = 0;
		frame.setLayout(new GridLayout(2, 2));
		frame.addWindowListener(new WindowClosedEvent(this));
		tbien.addActionListener(this);
		bien.addActionListener(this);
		bof.addActionListener(this);
		nul.addActionListener(this);
		frame.add(tbien);
		frame.add(bien);
		frame.add(bof);
		frame.add(nul);
		frame.setVisible(true);
		frame.pack();
	}

	public void afficheResultat() {
		System.out.println("RESULTAT");
		System.out.println("Tres bien : " + ntbien);
		System.out.println("Bien : " + nbien);
		System.out.println("Bof : " + nbof);
		System.out.println("Nul : " + nnul);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tbien) ntbien++;
		else if (e.getSource() == bien) nbien++;
		else if (e.getSource() == bof) nbof++;
		else if (e.getSource() == nul) nnul++;
	}

	class WindowClosedEvent extends WindowAdapter {
		private Eval eval;
		public WindowClosedEvent(Eval eval) { this.eval = eval; }
		@Override
		public void windowClosing(WindowEvent e) {
			eval.afficheResultat();
			System.exit(0);
		}
	}

	public static void main(String args[]) {
		new Eval();
	}

}


