package gui;

import gui.base.TextButton;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import scene.BattleGameScene;
import scene.CustomizeScene;
import sharedObject.RenderableHolder;
import application.Main;

public class MenuControlPane extends VBox {

	private Text gameText;
	public Button battleGameButton;
	public Button customizeButton;
	public Button howToPlayButton;
	public Button quitButton;

	public MenuControlPane() {
		super();
		this.setSpacing(10);
		this.setPadding(new Insets(10));
		this.setPrefWidth(450);
		this.setPrefHeight(500);
		this.setAlignment(Pos.CENTER);

		initializeGameText();
		initializeBattleGameButton();
		initializeCustomizeButton();
		initializeHowToPlayButton();
		initializeQuitButton();

		this.getChildren().addAll(gameText, battleGameButton, customizeButton, howToPlayButton, quitButton);
	}

	private void initializeGameText() {
		this.gameText = new Text("YELLOW");
		this.gameText.setFont(RenderableHolder.gameHeaderFont);
		this.gameText.setFill(Color.YELLOW);
	}

	private void initializeCustomizeButton() {
		this.customizeButton = new TextButton("Customize");
		this.customizeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				RenderableHolder.ClickedSound_music.play();
				Main.sceneHolder.switchScene(new CustomizeScene());
			}
		});
	}

	private void initializeBattleGameButton() {
		this.battleGameButton = new TextButton("BATTLE!");
		this.battleGameButton.setPrefHeight(85);
		this.battleGameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				RenderableHolder.ClickedSound_music.play();
				Main.sceneHolder.switchScene(new BattleGameScene());
			}
		});
	}

	private void initializeHowToPlayButton() {
		this.howToPlayButton = new TextButton("How to play");

	}

	private void initializeQuitButton() {
		this.quitButton = new TextButton("Quit");
		this.quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				RenderableHolder.ClickedSound_music.play();
				System.exit(0);
			}
		});
	}

}
