package gui;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import sharedObject.RenderableHolder;

public class MainMenuPane extends HBox {
	public MenuControlPane menuControlPane;

	public MainMenuPane() {
		super();

		this.setPrefSize(912, 500);
		this.setMaxSize(912, 500);
		this.setPadding(new Insets(30));
		this.setStyle("-fx-background-color: black; ");

		this.menuControlPane = new MenuControlPane();
		BorderPane imagePane = new BorderPane(new ImageView(RenderableHolder.mainMenuGIF));

		this.getChildren().addAll(menuControlPane, imagePane);

	}
}
