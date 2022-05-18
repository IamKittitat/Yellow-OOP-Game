package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import application.Main;
import constant.CharacterColor;
import gui.base.MenuButton;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.GameController;
import logic.GameLogic;
import scene.BattleGameScene;
import scene.MainMenuScene;
import sharedObject.RenderableHolder;

public class CustomizePane extends BorderPane {
	private SwitchColorPane pacManSwitchColorPane;
	private SwitchColorPane ghostSwitchColorPane;

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
		this.pacManSwitchColorPane = new SwitchColorPane(pacManColorImageList,pacManColorlList);

		ArrayList<CharacterColor> ghostColorlList = new ArrayList<CharacterColor>();
		ghostColorlList.add(CharacterColor.PINK);
		ghostColorlList.add(CharacterColor.GREEN);
		ghostColorlList.add(CharacterColor.PURPLE);
		
		ArrayList<Image> ghostColorImageList = new ArrayList<Image>();
		ghostColorImageList.add(RenderableHolder.pinkGhostGIF);
		ghostColorImageList.add(RenderableHolder.greenGhostGIF);
		ghostColorImageList.add(RenderableHolder.purpleGhostGIF);
		this.ghostSwitchColorPane = new SwitchColorPane(ghostColorImageList,ghostColorlList);

		Pane switchColorPane = new VBox(10);
		switchColorPane.getChildren().addAll(pacManSwitchColorPane, ghostSwitchColorPane);

		Button playButton = new MenuButton("Play");
		playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				saveColor();
				RenderableHolder.loadCharacter();
				Main.sceneHolder.switchScene(new BattleGameScene());
			}
		});
		
		Button mainMenuButton = new MenuButton("MainMenu");
		mainMenuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				saveColor();
				RenderableHolder.loadCharacter();
				Main.sceneHolder.switchScene(new MainMenuScene());
			}
		});

		Pane buttonPane = new VBox(5);
		buttonPane.setPadding(new Insets(30, 30, 30, 700));
		buttonPane.getChildren().addAll(playButton, mainMenuButton);

		this.setCenter(switchColorPane);
		this.setBottom(buttonPane);

	};
	
	public void saveColor() {
		GameLogic.setPacManColor(pacManSwitchColorPane.getColorList().get(pacManSwitchColorPane.getIdx()));
		GameLogic.setGhostColor(ghostSwitchColorPane.getColorList().get(ghostSwitchColorPane.getIdx()));
		
		System.out.println((GameLogic.getPacManColor()+"").toLowerCase());
		System.out.println(GameLogic.getGhostColor());
		System.out.println("save");
	}
}
