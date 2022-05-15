package gui;

import gui.base.MenuButton;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import scene.MainMenuScene;

public class GameControlPane extends BorderPane{
	private int point;
	private Text textPoint;
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
		this.setPoint(0);
		this.setLives(3);
		this.livesPane = new Pane();
		this.textPoint = new Text("Points : 0");
		this.pauseButton = new MenuButton("Pause");
		this.menuButton = new MenuButton("Menu");
		
		this.statPane = new VBox();
		this.statPane.getChildren().addAll(textPoint,livesPane);
		
		this.controlPane = new HBox();
		this.controlPane.getChildren().addAll(pauseButton,menuButton);
		
		this.setLeft(statPane);
		this.setRight(controlPane);
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
}
