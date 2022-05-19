package gui;

import gui.base.IconButton;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import sharedObject.RenderableHolder;

public class HowToPlayPane extends BorderPane {
	private boolean isHidden;
	private Button nextButton;
	private Button prevButton;
	private Button closeButton;
	private ImageView howToPlayDetails1;
	private ImageView howToPlayDetails2;

	public HowToPlayPane() {
		super();
		this.setStyle("-fx-background-color: black;" + "-fx-border-color: yellow; " + "-fx-border-radius: 30;"
				+ " -fx-border-width: 2px;");
		this.setMaxSize(600, 400);
		this.setTranslateY(600);
		this.isHidden = true;

		this.howToPlayDetails1 = new ImageView(RenderableHolder.howToPlay1PNG);
		this.howToPlayDetails2 = new ImageView(RenderableHolder.howToPlay2PNG);

		this.initializeButton();

		Pane buttonPane = new HBox(5);
		buttonPane.setPadding(new Insets(0, 10, 30, 500));
		buttonPane.getChildren().addAll(prevButton, nextButton);

		Pane closeButtonPane = new HBox();
		closeButtonPane.getChildren().add(closeButton);
		closeButtonPane.setPadding(new Insets(30, 10, 0, 600));

		this.setCenter(howToPlayDetails1);
		this.setBottom(buttonPane);
		this.setTop(closeButtonPane);
	}

	private void initializeButton() {
		this.nextButton = new IconButton(RenderableHolder.nextButtonPNG);
		this.nextButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				RenderableHolder.ClickedSound_music.play();
				setCenter(howToPlayDetails2);
				nextButton.setDisable(true);
				prevButton.setDisable(false);
			}
		});

		this.prevButton = new IconButton(RenderableHolder.previousButtonPNG);
		this.prevButton.setDisable(true);
		this.prevButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				RenderableHolder.ClickedSound_music.play();
				setCenter(howToPlayDetails1);
				nextButton.setDisable(false);
				prevButton.setDisable(true);
			}
		});

		this.closeButton = new IconButton(RenderableHolder.closeButtonPNG);
		this.closeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				RenderableHolder.ClickedSound_music.play();
				move();
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
}
