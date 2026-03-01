package com.github.matschieu.calculator.components;

/**
 * @author Matschieu
 */
public interface Calculator {

	public void setNumericScreen(String numb);
	public void setOperatorScreen(String op);
	public void resultCalculate();
	public void clearScreen();
	public void inverse();
	public void toReal();
	public void copy();
	public void paste();
	public void insertConstantValue(double value);
	public void displayInfo();
	public void exit();
	public void applyJavaSkin();
	public void applySystemSkin();

}
