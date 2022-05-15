package gui;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class HowToPlayPane extends VBox {
	private Text howToPlayHeader;
	private Text howToPlayDetails;
	private boolean isHidden;

	public HowToPlayPane() {
		super();
		// TODO Auto-generated constructor stub
		this.setStyle("-fx-background-color: white;");
		this.setPrefWidth(500);
		this.setPrefHeight(400);
		howToPlayDetails = new Text("Art of Element is an elemental battle game. \n You are a witch who "
				+ "is going to fight against mythic \ndungeon boss which you can choose in GameMenu.\nIn this game, you "
				+ "can move by using W,A,S,D buttons \n and you can cast your spell by pressing space bar.\n"
				+ "Every 7 seconds there will be item dropped on the map, "
				+ "\n pick it up to change your elemental type or heal yourself.");
	}

	public void enter() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);
		if (isHidden) {
			transition.setToY(50);
			transition.setToX(50);
			isHidden = false;
		} else {
			transition.setToX(0);
			transition.setToY(0);
			isHidden = true;
		}
		transition.play();
	}
}
