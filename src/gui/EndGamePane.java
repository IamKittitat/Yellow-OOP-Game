package gui;

import application.Main;
import gui.base.IconButton;
import gui.base.MenuButton;
import javafx.animation.TranslateTransition;
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
import javafx.util.Duration;
import logic.GameController;
import logic.GameLogic;
import scene.BattleGameScene;
import scene.CustomizeScene;
import sharedObject.RenderableHolder;

public class EndGamePane extends BorderPane {
	private boolean isHidden;
	private Text resultText;
	private Button quitButton;

	public EndGamePane() {
		super();
		// TODO Auto-generated constructor stub
		this.setStyle("-fx-background-color: black;" + "-fx-border-color: yellow; " + "-fx-border-radius: 30;"
				+ " -fx-border-width: 2px;");
		setMaxSize(600, 400);
		this.setPadding(new Insets(120,30,0,30));
		this.isHidden = true;
		
		this.resultText = new Text();
		this.resultText.setFont(RenderableHolder.gameHeaderFont);
		this.resultText.setFill(Color.YELLOW);

		this.setTranslateY(600);
		
		
		this.quitButton = new MenuButton("Quit");
		this.quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				RenderableHolder.ClickedSound_music.play();
				System.exit(0);
			}
		});


		Pane buttonPane = new HBox(5);
		buttonPane.setPadding(new Insets(30, 30, 30, 400));
		buttonPane.getChildren().add(quitButton);

		this.setBottom(buttonPane);
	}

	public void enter() {
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
		if(GameLogic.pacManWin()) {
			this.resultText.setText("Pac-Man WIN!");
			this.setRight(new ImageView(RenderableHolder.pinkPacManGIF));
			this.setLeft(new ImageView(RenderableHolder.yellowPacManGIF));
		}else if(GameLogic.GhostWin()) {
			this.resultText.setText("Ghost WIN!");
			this.setRight(new ImageView(RenderableHolder.pinkGhostGIF));
			this.setLeft(new ImageView(RenderableHolder.greenGhostGIF));
		}
		this.setCenter(resultText);
	}
}
