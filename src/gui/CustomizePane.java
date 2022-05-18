package gui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import scene.MainMenuScene;
import sharedObject.RenderableHolder;

public class CustomizePane extends BorderPane {
	private SwitchColorPane pacManSwitchColorPane;
	private SwitchColorPane ghostSwitchColorPane;

	public CustomizePane() {
		
		this.setPrefSize(912, 500);
		this.setMaxSize(912, 500);

		ArrayList<Image> pacManColorList = new ArrayList<Image>();
		pacManColorList.add(RenderableHolder.yellowPacManGIF);
		pacManColorList.add(RenderableHolder.pinkPacManGIF);
		pacManColorList.add(RenderableHolder.bluePacManGIF);
		this.pacManSwitchColorPane = new SwitchColorPane(pacManColorList);
		
		ArrayList<Image> ghostColorList = new ArrayList<Image>();
		ghostColorList.add(RenderableHolder.pinkGhostGIF);
		ghostColorList.add(RenderableHolder.greenGhostGIF);
		ghostColorList.add(RenderableHolder.purpleGhostGIF);
		this.ghostSwitchColorPane = new SwitchColorPane(ghostColorList);
		
		this.setTop(pacManSwitchColorPane);   
		this.setBottom(ghostSwitchColorPane);
	};
}
