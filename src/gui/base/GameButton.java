package gui.base;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class GameButton extends Button {

	public GameButton() {
		this(null);
	}

	public GameButton(String arg0) {
		super(arg0);
		this.setStyle("-fx-background-color: transparent; ");
		this.setAction();

	}

	private void setAction() {
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
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
				setEffect(null);
			}
		});
	}
}
