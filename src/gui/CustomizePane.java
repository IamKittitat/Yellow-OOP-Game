package gui;

import java.util.ArrayList;
import application.Main;
import constant.CharacterColor;
import gui.base.TextButton;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import logic.GameLogic;
import scene.BattleGameScene;
import scene.MainMenuScene;
import sharedObject.RenderableHolder;

public class CustomizePane extends BorderPane {
	private SwitchColorPane pacManSwitchColorPane;
	private SwitchColorPane ghostSwitchColorPane;
	private Button playButton;
	private Button mainMenuButton;

	public CustomizePane() {

		this.setPrefSize(912, 500);
		this.setMaxSize(912, 500);
		this.setStyle("-fx-background-color: black; ");

		ArrayList<CharacterColor> pacManColorlList = new ArrayList<CharacterColor>();
		pacManColorlList.add(CharacterColor.YELLOW);
		pacManColorlList.add(CharacterColor.PINK);
		pacManColorlList.add(CharacterColor.BLUE);

		ArrayList<Image> pacManColorImageList = new ArrayList<Image>();
		pacManColorImageList.add(RenderableHolder.yellowPacManGIF);
		pacManColorImageList.add(RenderableHolder.pinkPacManGIF);
		pacManColorImageList.add(RenderableHolder.bluePacManGIF);
		this.pacManSwitchColorPane = new SwitchColorPane(pacManColorImageList, pacManColorlList);

		ArrayList<CharacterColor> ghostColorlList = new ArrayList<CharacterColor>();
		ghostColorlList.add(CharacterColor.PINK);
		ghostColorlList.add(CharacterColor.GREEN);
		ghostColorlList.add(CharacterColor.PURPLE);

		ArrayList<Image> ghostColorImageList = new ArrayList<Image>();
		ghostColorImageList.add(RenderableHolder.pinkGhostGIF);
		ghostColorImageList.add(RenderableHolder.greenGhostGIF);
		ghostColorImageList.add(RenderableHolder.purpleGhostGIF);
		this.ghostSwitchColorPane = new SwitchColorPane(ghostColorImageList, ghostColorlList);

		VBox switchColorPane = new VBox(10);
		switchColorPane.setPadding(new Insets(30, 100, 0, 100));
		switchColorPane.getChildren().addAll(pacManSwitchColorPane, ghostSwitchColorPane);

		this.initializePlayButton();
		this.initializeMainMenuButton();

		VBox buttonPane = new VBox(5);
		buttonPane.setPadding(new Insets(0, 30, 30, 30));
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(playButton, mainMenuButton);

		this.setCenter(switchColorPane);
		this.setBottom(buttonPane);

	};

	private void initializePlayButton() {
		this.playButton = new TextButton("Play");
		this.playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				RenderableHolder.ClickedSound_music.play();
				saveColor();
				RenderableHolder.loadCharacter();
				Main.sceneHolder.switchScene(new BattleGameScene());
			}
		});
	}

	private void initializeMainMenuButton() {
		this.mainMenuButton = new TextButton("MainMenu");
		this.mainMenuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				RenderableHolder.ClickedSound_music.play();
				RenderableHolder.ThemeSong_music.stop();
				MainMenuScene.startThemeSong.stop();
				saveColor();
				RenderableHolder.loadCharacter();
				Main.sceneHolder.switchScene(new MainMenuScene());
			}
		});
	}

	private void saveColor() {
		GameLogic.setPacManColor(pacManSwitchColorPane.getColorList().get(pacManSwitchColorPane.getIdx()));
		GameLogic.setGhostColor(ghostSwitchColorPane.getColorList().get(ghostSwitchColorPane.getIdx()));
	}
}
