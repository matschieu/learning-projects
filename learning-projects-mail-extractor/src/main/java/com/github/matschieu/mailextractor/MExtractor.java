package com.github.matschieu.mailextractor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
* @author Matschieu
 */
public class MExtractor {

	private final String APPLICATION_NAME = "M-MailExtractor";
	private final String APPLICATION_VERSION = "3.0.1";

	private MenuBar menuBar;
	private ButtonsBar buttonsBar;
	private TextArea textAreaA;
	private TextArea textAreaB;
	private Report report;

	public MExtractor() {
		JFrame frame = new JFrame(APPLICATION_NAME);
		menuBar = new MenuBar(this);
		buttonsBar = new ButtonsBar(this);
		textAreaA = new TextArea();
		textAreaB = new TextArea();
		report = new Report();
		frame.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(textAreaA);
		panel.add(textAreaB);
		frame.setJMenuBar(menuBar);
		frame.add(buttonsBar, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(report, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(150, 10);
		frame.pack();
		frame.setVisible(true);
	}

	public void applyJavaSkin(JFrame frame) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(frame);
		}
		catch(Exception e) { }
	}

	public void applySystemSkin(JFrame frame) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(frame);
		}
		catch(Exception e) { }
	}

	public void clear() {
		textAreaA.setText("");
		textAreaB.setText("");
		report.append("Zone du haut et du bas effacées");
	}

	public void open() {
		JFileChooser fileChooser = new JFileChooser();
		if(fileChooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
			try {
				String path = fileChooser.getCurrentDirectory() + File.separator + fileChooser.getSelectedFile().getName();
				IOFile file = new IOFile();
				file.open(path);
				clear();
				textAreaA.setText(file.read());
				file.close();
				report.append("Lecture du fichier " + path + " dans la zone du haut");
			}
			catch(FileNotFoundException e) { report.append(e.toString()); }
			catch(ReadFileException e) { report.append(e.toString()); }
		}
	}

	public void save() {
		JFileChooser fileChooser = new JFileChooser();
		if(fileChooser.showSaveDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
			try {
				String path = fileChooser.getCurrentDirectory() + File.separator + fileChooser.getSelectedFile().getName();
				IOFile file = new IOFile();
				file.open(path);
				file.write(textAreaB.getText());
				file.close();
				report.append("Ecriture de la zone du bas dans le fichier " + path);
			}
			catch(FileNotFoundException e) { report.append(e.toString()); }
			catch(WriteFileException e) { report.append(e.toString()); }
		}
	}

	public void extract() {
		if (!textAreaA.getText().equals("")) {
			Extractor ext = new Extractor();
			textAreaB.setText(ext.extract(textAreaA.getText()));
			report.append("Mailing list correctement générée");
		}
	}

	public void exit() { System.exit(0); }

	public void displayInfo() {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(APPLICATION_NAME + " " + APPLICATION_VERSION + "\n");
		strBuf.append("Developped with Java\n");
		strBuf.append("(c) Matschieu, 2007\n");
		JOptionPane.showMessageDialog(null, strBuf, APPLICATION_NAME, JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public String toString() { return APPLICATION_NAME + " " + APPLICATION_VERSION; }

	public static void main(String[] args) { new MExtractor(); }

}
