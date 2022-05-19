package application;

import javafx.application.Application;
import javafx.stage.Stage;
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
