package gui;

import entity.character.PacMan;
import gui.base.MenuButton;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.GameController;
import scene.MainMenuScene;
import sharedObject.RenderableHolder;

public class GameControlPane extends BorderPane{
	private int score;
	private Text scoreText;
	private int lives;
	private Pane livesPane;
	private Button pauseButton;
	private Button menuButton;
	private Pane statPane;
	private Pane controlPane;
	
	public GameControlPane() {
		super();
		initilize();
		this.setPrefWidth(900);
		this.setPrefHeight(50);
		// TODO Auto-generated constructor stub
	}
	
	private void initilize() {

		this.livesPane = new Pane();
		ImageView heartImageView = new ImageView(RenderableHolder.heartPNG);
		this.livesPane.getChildren().add(heartImageView);
		
		this.scoreText = new Text("Score : 0");
		this.pauseButton = new MenuButton("Pause");
		this.menuButton = new MenuButton("Menu");
		
		this.statPane = new VBox();
		this.statPane.getChildren().addAll(scoreText,livesPane);
		
		this.controlPane = new HBox();
		this.controlPane.getChildren().addAll(pauseButton,menuButton);
		
		this.setLeft(statPane);
		this.setRight(controlPane);
		
		this.updateScore();
		this.updateLives();
	}

	public void updateScore() {
		this.score = GameController.pacMan.getScore();
		this.scoreText.setText("Score : " + this.score);
	}

	public void updateLives() {
		this.lives = GameController.pacMan.getLife();
		while(this.livesPane.getChildren().size()>this.lives)
			this.livesPane.getChildren().remove(0);
	}
}
