package gui.base;

import application.Main;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import scene.PacManGameScene;

public class MenuButton extends GameButton {

	private GameText buttonText;

	public MenuButton(String arg0) {
		super(arg0);
		this.setPrefWidth(300);
		this.setPrefHeight(50);
		this.setStyle("-fx-background-color: transparent; "
		+"-fx-border-color: yellow; " 
				+ "-fx-border-radius: 30;"
		+"-fx-text-fill: yellow;"
				+" -fx-border-width: 2px;"
		+"-fx-font-weight: 300;"
				+"-fx-font-size:20;");
	}



}
