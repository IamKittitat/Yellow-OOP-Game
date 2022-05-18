package application;

import gui.MenuControlPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import scene.MainMenuScene;
import scene.SceneHolder;
import sharedObject.RenderableHolder;

public class Main extends Application {
	public static SceneHolder sceneHolder;

	@Override
	public void start(Stage primaryStage) throws Exception {

		(sceneHolder = new SceneHolder(primaryStage)).initialize();
		primaryStage.setTitle("Yellow");
		primaryStage.getIcons().add(RenderableHolder.gameIconPNG);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
