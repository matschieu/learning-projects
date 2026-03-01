package com.github.matschieu.editor.edit.components;

/**
 * @author Matschieu
 */
public interface Editor {

	public boolean wantToSave();
	public void newDocument();
	public void openFile();
	public void saveFile();
	public void saveFileAs();
	public void replace();
	public void applyJavaSkin();
	public void applySystemSkin();
	public void displayInfo();
	public void exit();

}
