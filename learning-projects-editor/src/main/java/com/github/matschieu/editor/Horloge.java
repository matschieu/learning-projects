package com.github.matschieu.editor;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author Matschieu
 */
public class Horloge extends JPanel {

	private static final long serialVersionUID = -4601807573331395969L;

	private JLabel label;
	private int hours;
	private int minutes;
	private int secondes;
	private int GMT;

	public Horloge () { this(1); }
	public Horloge (int gmt) {
		hours = minutes = secondes = 0;
		GMT = gmt;
		defaultStyle();
		add(label);
	}

	public void run() {
		while(true) {
			Calendar c = new GregorianCalendar(TimeZone.getTimeZone("GMT+" + GMT));
			StringBuffer str = new StringBuffer("");
			hours = c.get(Calendar.HOUR_OF_DAY);// + 1;
			minutes = c.get(Calendar.MINUTE);
			secondes = c.get(Calendar.SECOND);
			str.append((hours < 10 ? "0" + hours : hours) + ":");
			str.append((minutes < 10 ? "0" + minutes : minutes) + ":");
			str.append((secondes < 10 ? "0" + secondes : secondes));
			label.setText(str.toString());
			try { Thread.sleep(1000); }
			catch(InterruptedException e) { label.setText("<html><font color=ff0000><b>Error</b></font></html>"); }
		}
	}

	public void setGMT(int gmt) { GMT = gmt; }
	public void setBgColor(int r, int g, int b) { label.setBackground(new Color(r, g, b)); }
	public void setFgColor(int r, int g, int b) { label.setForeground(new Color(r, g, b)); }
	public void setFont(boolean bold, int size) { label.setFont(new Font("Default", bold ? Font.BOLD : Font.PLAIN, size)); }
	public void defaultStyle() {
		if (label != null) remove(label);
		label = new JLabel("-:-:-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);
	}

	public static void main( String[] args) {
		JFrame frame = new JFrame();
		Horloge horloge = new Horloge();
		JLabel lab = new JLabel("(c) Matschieu");
		lab.setHorizontalAlignment(SwingConstants.CENTER);
		horloge.setFont(true, 60);
		//horloge.setFgColor(51, 51, 153);
		frame.setLayout(new java.awt.BorderLayout());
		frame.add(new JLabel(new javax.swing.ImageIcon(Horloge.class.getClassLoader().getResource("./Horloge.png"))), java.awt.BorderLayout.NORTH);
		frame.add(horloge, java.awt.BorderLayout.CENTER);
		frame.add(lab, java.awt.BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		horloge.run();
	}

}
