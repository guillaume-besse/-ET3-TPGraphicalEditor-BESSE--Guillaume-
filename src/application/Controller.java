package application;




import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Controller {

	
	private Modele model;
	
	public Controller() {
		model= new Modele(this,false,false,false,false);
	}
	
	@FXML
	private RadioButton select; 
	
	@FXML
	private RadioButton elipse; 
	
	@FXML
	private RadioButton rectangle; 
	
	@FXML
	private RadioButton line; 
	
	@FXML
	private ColorPicker couleur;
	
	@FXML
	private Button delete; 
	
	@FXML
	private Button clone; 
	
	@FXML
	private Pane dessin;
	
	private java.util.ArrayList<Double> listeX;
	private java.util.ArrayList<Double> listeY;
	private java.util.ArrayList<Rectangle> listeRect;
	
	
	
	@FXML
	private void clickOnSelect(ActionEvent event)
	{
	    model.setSelect(true);
	    model.setElipse(false);
	    model.setRectangle(false);
	    model.setLine(false);
	}
	private void clickOnElipse(ActionEvent event)
	{
	    model.setSelect(false);
	    model.setElipse(true);
	    model.setRectangle(false);
	    model.setLine(false);
	}
	private void clickOnRectangle(ActionEvent event)
	{
	    model.setSelect(false);
	    model.setElipse(false);
	    model.setRectangle(true);
	    model.setLine(false);
	}
	private void clickOnLine(ActionEvent event)
	{
	    model.setSelect(false);
	    model.setElipse(false);
	    model.setRectangle(false);
	    model.setLine(true);
	}
	
	
	
	
	private void clickPane(MouseEvent event) {
		
		
		if (model.getRectangle()==true) {
			
			
			listeX.add(event.getX());
			listeY.add(event.getY());
			
			
			
				Rectangle rec=new Rectangle(listeX.get(listeX.size()-1),listeY.get(listeY.size()-1),event.getX(),event.getY());
				listeRect.add(rec);
				rec.addEventHandler(MouseEvent.MOUSE_PRESSED , new EventHandler<MouseEvent>(){
					
					public void handle(MouseEvent event) {
						if(model.getSelect()==true) {
							rec.setWidth(listeRect.get(listeRect.size()-1).getWidth()+20);
							rec.setHeight(listeRect.get(listeRect.size()-1).getHeight()+20);
							rec.setFill(model.getColor());
						}
					}
				});
				
				
				rec.addEventHandler(MouseEvent.MOUSE_DRAGGED , new EventHandler<MouseEvent>(){
					
					public void handle(MouseEvent event) {
						((Rectangle)event.getTarget()).setX(event.getX());
						((Rectangle)event.getTarget()).setY(event.getY());
						
					}
				});
				
				rec.addEventHandler(MouseEvent.MOUSE_RELEASED , new EventHandler<MouseEvent>(){
					
					public void handle(MouseEvent event) {
						if(model.getSelect()==true) {
							listeRect.get(listeRect.size()-1).setWidth(listeRect.get(listeRect.size()-1).getWidth()-20);
							listeRect.get(listeRect.size()-1).setHeight(listeRect.get(listeRect.size()-1).getHeight()-20);
						}
					}
				});
				
				
				rec.setFill(model.getColor());
				
				
				
				
				dessin.getChildren().add(rec);
			
			
			
		}
		
	}	
	
	
	private void finClick(MouseEvent event) {
		
		if (model.getRectangle()==true) {
			listeRect.get(listeRect.size()-1).setWidth(event.getX()-listeX.get(listeX.size()-1));
			listeRect.get(listeRect.size()-1).setHeight(event.getY()-listeY.get(listeY.size()-1));
		}
	}
	
	
	private void changeCouleur(ActionEvent event) {
		model.setColor(couleur.getValue());
	}
	
	@FXML
    public void initialize(){
		
		
		model.setColor(couleur.getValue());
		listeX=new java.util.ArrayList<Double>();
		listeY=new java.util.ArrayList<Double>();
		listeRect = new java.util.ArrayList<Rectangle>();
		
		
		
		select.setOnAction(this::clickOnSelect);
		elipse.setOnAction(this::clickOnElipse);
		rectangle.setOnAction(this::clickOnRectangle);
		line.setOnAction(this::clickOnLine);
		
		couleur.setOnAction(this::changeCouleur);
		
		dessin.setOnMousePressed(this::clickPane);
		dessin.setOnMouseDragged(this::finClick);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
