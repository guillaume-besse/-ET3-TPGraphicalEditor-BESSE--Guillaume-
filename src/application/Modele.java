package application;

import javafx.scene.paint.Color;

public class Modele {

	// les boolean prcisent si oui ou non les radioButton sont séléctionnés
	private boolean select;
	private boolean elipse;
	private boolean rectangle;
	private boolean line;
	private Controller control;
	private Color color;
	
	
	public Modele(Controller control,boolean select,boolean elipse,boolean rectangle, boolean line) {
		this.control=control;
		this.select=select;
		this.elipse=elipse;
		this.rectangle=rectangle; 
		this.line=line;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color=color;
	}
	public boolean getSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select=select;
	}
	public boolean getElipse() {
		return elipse;
	}
	public void setElipse(boolean elipse) {
		this.elipse=elipse;
	}
	public boolean getRectangle() {
		return rectangle;
	}
	public void setRectangle(boolean rectangle) {
		this.rectangle=rectangle; 
	}
	public boolean getLine() {
		return line;
	}
	public void setLine(boolean line) {
		this.line=line;	
	}
	
	
	
}
