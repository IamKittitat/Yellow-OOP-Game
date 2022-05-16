package gui;

import gui.base.MenuButton;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import scene.BattleGameScene;
import scene.CustomiseScene;
import scene.MainMenuScene;
import scene.PacManGameScene;
import application.Main;

public class MenuControlPane extends VBox {

	private Text gameText;
	private Button battleGameButton;
	private Button pacManGameButton;
	private Button customizeButton;
	private Button howToPlayButton;
	private Button quitButton;
	private HowToPlayPane howToPlayPane;
	private static Stage primaryStage;

	public MenuControlPane() {
		super();
		this.setSpacing(10);
		this.setPadding(new Insets(10));
		this.setPrefWidth(450);
		this.setPrefHeight(500);
		this.setAlignment(Pos.CENTER);

		initializeGameText();
		initializeBattleGameButton();
		initializePacManGameButton();
		initializeCustomizeButton();
		initializeHowToPlayButton();
		initializeQuitButton();

		this.getChildren().addAll(gameText, battleGameButton, pacManGameButton, customizeButton, howToPlayButton,
				quitButton);
	}

	private void initializeHowToPlayButton() {
		// TODO Auto-generated method stub
		this.howToPlayButton = new MenuButton("How to play");
		this.howToPlayPane = new HowToPlayPane();
		this.howToPlayButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				howToPlayPane.enter();
			}
		});
	}

	private void initializeCustomizeButton() {
		// TODO Auto-generated method stub
		this.customizeButton = new MenuButton("Customize");
	}

	private void initializePacManGameButton() {
		// TODO Auto-generated method stub
		this.pacManGameButton = new MenuButton("Pac-man vs Pac-man");

	}

	private void initializeBattleGameButton() {
		// TODO Auto-generated method stub
//		this.battleGameButton = new MenuButton("BATTLE!",new Scene(new BattleGameScene()));
		this.battleGameButton = new MenuButton("BATTLE!");
		this.battleGameButton.setPrefHeight(85);
		this.battleGameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Main.sceneHolder.switchScene(new Scene(new BattleGameScene()));
			}
		});
	}

	private void initializeGameText() {
		// TODO Auto-generated method stub
		this.gameText = new Text("PAC-MAN");
	}

	private void initializeQuitButton() {
		// TODO Auto-generated method stub
		this.quitButton = new MenuButton("Quit");
		this.quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}

}
