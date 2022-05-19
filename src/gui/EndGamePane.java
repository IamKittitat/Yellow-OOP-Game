package gui;

import application.Main;
import gui.base.TextButton;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import logic.GameLogic;
import scene.MainMenuScene;
import sharedObject.RenderableHolder;

public class EndGamePane extends BorderPane {
	private boolean isHidden;
	private Text resultText;
	private Button backToMainMenuButton;
	private Button quitButton;

	public EndGamePane() {
		super();
		this.setStyle("-fx-background-color: black;" + "-fx-border-color: yellow; " + "-fx-border-radius: 30;"
				+ " -fx-border-width: 2px;");
		this.setMaxSize(600, 400);
		this.setPadding(new Insets(120, 30, 0, 30));
		this.setTranslateY(600);

		this.isHidden = true;

		this.initializeResultText();
		this.initializeBackToMainMenuButton();
		this.initializeQuitButton();

		VBox buttonPane = new VBox(10);
		buttonPane.setPrefWidth(900);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setPadding(new Insets(30, 0, 30, 0));
		buttonPane.getChildren().addAll(backToMainMenuButton, quitButton);

		this.setCenter(resultText);
		this.setBottom(buttonPane);
	}

	private void initializeResultText() {
		this.resultText = new Text();
		this.resultText.setFont(RenderableHolder.gameHeaderFont);
		this.resultText.setFill(Color.YELLOW);
	}

	private void initializeBackToMainMenuButton() {
		this.backToMainMenuButton = new TextButton("Main Menu");
		this.backToMainMenuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				RenderableHolder.ClickedSound_music.play();
				Main.sceneHolder.switchScene(new MainMenuScene());
				GameLogic.restartGame();
			}
		});
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

	public void move() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);
		if (isHidden) {
			transition.setToY(0);
			transition.setToX(0);
			isHidden = false;
		} else {
			transition.setToY(600);
			isHidden = true;
		}
		transition.play();
	}

	public void setResult() {
		if (GameLogic.pacManWin()) {
			this.resultText.setText("Pac-Man WIN!");
			this.setRight(new ImageView(RenderableHolder.pinkPacManGIF));
			this.setLeft(new ImageView(RenderableHolder.yellowPacManGIF));
		} else if (GameLogic.GhostWin()) {
			this.resultText.setText("Ghost WIN!");
			this.setRight(new ImageView(RenderableHolder.pinkGhostGIF));
			this.setLeft(new ImageView(RenderableHolder.greenGhostGIF));
		}
	}
}
