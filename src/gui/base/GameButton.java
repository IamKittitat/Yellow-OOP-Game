package gui.base;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class GameButton extends Button {

	public GameButton() {
		super();
		setAction();
		// TODO Auto-generated constructor stub
	}

	public GameButton(String arg0) {
		super(arg0);
		setAction();
		this.setStyle("-fx-background-color: transparent; ");
		// TODO Auto-generated constructor stub
	}
	
	private void setAction() {
		// TODO Auto-generated method stub
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				DropShadow shadow = new DropShadow();
				shadow.setColor(Color.YELLOW);
				shadow.setSpread(0.4);
				shadow.setRadius(10);
				setEffect(shadow);
			}
		});

		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setEffect(null);
			}
		});
		
	}

}
