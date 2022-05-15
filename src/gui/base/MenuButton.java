package gui.base;

import application.Main;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import scene.PacManGameScene;

public class MenuButton extends Button {
	private Scene bindScene;
	private GameText buttonText;

	public MenuButton(String arg0) {
		this(arg0,null);
	}

	public MenuButton(String arg0, Scene nextScene) {
		super(arg0);
		// TODO Auto-generated constructor stub
		this.setPrefWidth(300);
		this.setPrefHeight(50);
		this.bindScene = nextScene;
		this.setStyle("-fx-background-color: transparent; " + "-fx-border-color: white; " + "-fx-border-radius: 30;");
		setAction();
	}

	private void setAction() {
		// TODO Auto-generated method stub
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setEffect(new DropShadow());
			}
		});

		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setEffect(null);
			}
		});
		
		if(this.bindScene != null) {
			setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					// TODO Auto-generated method stub
					Main.sceneHolder.switchScene(bindScene);
				}
			});
		}
	}

}
