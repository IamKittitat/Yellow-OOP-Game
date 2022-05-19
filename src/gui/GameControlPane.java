package gui;

import application.Main;
import gui.base.IconButton;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import logic.GameController;
import logic.GameLogic;
import scene.MainMenuScene;
import sharedObject.RenderableHolder;

public class GameControlPane extends BorderPane {
	private int score;
	private Text scoreText;
	private int lives;
	private Pane livesPane;
	private Button pauseButton;
	private Button menuButton;
	private Pane statPane;
	private Pane controlPane;
	private Boolean isPaused;

	public GameControlPane() {
		super();
		this.setPrefWidth(900);
		this.setPrefHeight(100);
		this.setPadding(new Insets(6));
		this.isPaused = false;

		this.initilizeLivesPane();
		this.initilizeScoreText();
		this.initilizePauseButton();
		this.initilizeMenuButton();

		this.statPane = new VBox();
		this.statPane.setPadding(new Insets(6));
		this.statPane.getChildren().addAll(scoreText, livesPane);
		this.updateScore();
		this.updateLives();

		this.controlPane = new HBox();
		this.controlPane.getChildren().addAll(pauseButton, menuButton);

		this.setLeft(statPane);
		this.setRight(controlPane);

	}

	private void initilizeScoreText() {
		this.scoreText = new Text("Score : 0");
		this.scoreText.setStyle("-fx-font-size:20;");
		this.scoreText.setFont(RenderableHolder.gameHeaderFont);
		this.scoreText.setFill(Color.YELLOW);
	}

	private void initilizeLivesPane() {
		this.livesPane = new HBox(5);
		this.livesPane.setMinHeight(25);
		this.lives = GameController.pacMan.getLife();
		for (int i = 0; i < this.lives; i++) {
			this.livesPane.getChildren().add(new ImageView(RenderableHolder.heartPNG));
		}
	}

	private void initilizePauseButton() {
		this.pauseButton = new IconButton(RenderableHolder.pauseButtonPNG);
		this.pauseButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				RenderableHolder.ClickedSound_music.play();

				if (!isPaused) {
					GameCanvas.gameLoop.stop();
					pauseButton.setGraphic(new ImageView(RenderableHolder.playButtonPNG));
					isPaused = true;
				} else {
					GameCanvas.gameLoop.start();
					pauseButton.setGraphic(new ImageView(RenderableHolder.pauseButtonPNG));
					isPaused = false;
				}
			}
		});
	}

	private void initilizeMenuButton() {
		this.menuButton = new IconButton(RenderableHolder.menuButtonPNG);
		this.menuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				RenderableHolder.ClickedSound_music.play();
				Main.sceneHolder.switchScene(new MainMenuScene());
				GameLogic.restartGame();
			}
		});
	}

	public void updateScore() {
		this.score = GameController.pacMan.getScore();
		this.scoreText.setText("Score : " + this.score);
	}

	public void updateLives() {
		this.lives = GameController.pacMan.getLife();
		while (this.livesPane.getChildren().size() > this.lives && this.lives >= 0)
			this.livesPane.getChildren().remove(0);
	}
}
