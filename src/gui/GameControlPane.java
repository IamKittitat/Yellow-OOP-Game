package gui;

import entity.character.PacMan;
import gui.base.IconButton;
import gui.base.MenuButton;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
		initilize();
		this.setPrefWidth(900);
		this.setPrefHeight(50);
		// TODO Auto-generated constructor stub
	}

	private void initilize() {

		initilizeLivesPane();

		this.scoreText = new Text("Score : 0");
		this.scoreText.setFont(RenderableHolder.gameHeaderFont);
		this.scoreText.setFill(Color.YELLOW);
		this.scoreText.setStyle("-fx-font-size:20;");

		this.isPaused = false;

		this.pauseButton = new IconButton(RenderableHolder.pauseButtonPNG);
		this.pauseButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
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
		this.menuButton = new IconButton(RenderableHolder.menuButtonPNG);

		this.statPane = new VBox();
		this.statPane.getChildren().addAll(scoreText, livesPane);

		this.controlPane = new HBox();
		this.controlPane.getChildren().addAll(pauseButton, menuButton);

		this.setLeft(statPane);
		this.setRight(controlPane);

		this.updateScore();
		this.updateLives();
	}

	public void initilizeLivesPane() {
		this.livesPane = new HBox();
		this.lives = GameController.pacMan.getLife();
		for (int i = 0; i < this.lives; i++) {
			this.livesPane.getChildren().add(new ImageView(RenderableHolder.heartPNG));
		}
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
