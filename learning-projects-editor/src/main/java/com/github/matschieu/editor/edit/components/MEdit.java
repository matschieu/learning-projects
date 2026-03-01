package com.github.matschieu.editor.edit.components;


import java.awt.BorderLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.github.matschieu.editor.edit.util.IOFile;
import com.github.matschieu.editor.edit.util.TextTools;

/**
 * @author Matschieu
 */
public class MEdit implements Editor {

	public static final String APPLICATION_NAME = "M-EDIT";
	public static final String APPLICATION_VERSION = "v0.0.1";
	private static final String LINE_SEP = System.getProperty("line.separator");

	private Frame frame;
	private MenuBar menuBar;
	private ToolsBar tools;
	private TextArea textArea;
	private Report report;
	private Label state;
	private IOFile file;

	public MEdit() {
		this.frame = new Frame(APPLICATION_NAME + "- Nouveau document" );
		this.textArea = new TextArea(20, 50);
		this.report = new Report();
		this.state = new Label();
		this.file = new IOFile();
		this.menuBar = new MenuBar(this);
		this.tools = new ToolsBar(this);

		frame.setLayout(new BorderLayout(1,1));
		frame.setJMenuBar(menuBar);
		frame.add(tools, BorderLayout.NORTH);
		JPanel middlePane = new JPanel();
			middlePane.setLayout(new BorderLayout());
			middlePane.add(textArea, BorderLayout.CENTER);
			middlePane.add(report, BorderLayout.SOUTH);
		frame.add(middlePane, BorderLayout.CENTER);
		frame.add(state, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public boolean wantToSave() {
		if (!file.isOpen() && textArea.getText().equals("")) return true;
		int returnValue = JOptionPane.showConfirmDialog(null, new JLabel("Voulez-vous enregistrer le fichier ?"), "Enregistrer", JOptionPane.YES_NO_CANCEL_OPTION);
		if (returnValue == JOptionPane.OK_OPTION) saveFile();
		if (returnValue == JOptionPane.CANCEL_OPTION) return false;
		return true;
	}

	@Override
	public void newDocument() {
		if (wantToSave()) {
			file.close();
			textArea.clear();
			frame.setTitle(APPLICATION_NAME + "- Nouveau document" );
			report.setText("Nouveau document");
		}
	}

	@Override
	public void openFile() {
		if (wantToSave()) {
			JFileChooser fileChooser = new JFileChooser();
			String filePath = "";
			int returnValue = fileChooser.showOpenDialog(new JFrame());
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				filePath = fileChooser.getCurrentDirectory() + File.separator + fileChooser.getSelectedFile().getName();
				try {
					file.open(filePath);
					textArea.clear();
					textArea.setText(file.read());
					frame.setTitle(APPLICATION_NAME + " - " + filePath);
					report.setText("Fichier ouvert : " + file.toString());
				}
				catch(Exception e) { report.setText(e.toString()); }
			}
		}
	}

	@Override
	public void saveFile() {
		if (!file.isOpen()) saveFileAs();
		else
			try {
				file.write(textArea.getText());
				report.setText("Fichier sauvegard� : " + file.toString());
			}
			catch(Exception e) { report.setText(e.toString()); }
	}

	@Override
	public void saveFileAs() {
		JFileChooser fileChooser = new JFileChooser();
		String filePath = "";
		int returnValue = fileChooser.showSaveDialog(new JFrame());
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			filePath = fileChooser.getCurrentDirectory() + File.separator + fileChooser.getSelectedFile().getName();
			try {
				file.open(filePath);
				file.write(textArea.getText());
				frame.setTitle(APPLICATION_NAME + " - " + filePath);
				report.setText("Fichier sauvegard� : " + file.toString());
			}
			catch(Exception e) { report.setText(e.toString()); }
		}
	}

	@Override
	public void replace() {
		ReplacePanel rp = new ReplacePanel();
		int returnValue = JOptionPane.showConfirmDialog(null, rp, "Remplacer", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon());
		if (returnValue == JOptionPane.OK_OPTION) {
			String search = rp.getSearch();
			String replace = rp.getReplace();
			String str = TextTools.replace(textArea.getText(), search, replace);
			textArea.clear();
			textArea.setText(str);
			report.setText("Les occurrences du mot " + search + " ont �t� remplac�es par " + replace);
		}
	}

	@Override
	public void applyJavaSkin() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(frame);
		}
		catch(Exception e) { }
	}

	@Override
	public void applySystemSkin() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(frame);
		}
		catch(Exception e) { }
	}

	@Override
	public void displayInfo() {
		JOptionPane.showMessageDialog(null, toString(), APPLICATION_NAME, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(""));
	}

	@Override
	public String toString() {
		StringBuffer strbuf = new StringBuffer("");
		strbuf.append(APPLICATION_NAME + " " + APPLICATION_VERSION + LINE_SEP);
		strbuf.append("Developped with Java" + LINE_SEP);
		strbuf.append("(c) Matschieu, 2007" + LINE_SEP);
		return strbuf.toString();
	}

	@Override
	public void exit() {
		wantToSave();
		report.setText("Fin du programme");
		System.exit(0);
	}

	//public static void main(String[] args) { new MEdit(); }

}
