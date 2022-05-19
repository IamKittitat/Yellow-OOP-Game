package scene;

import gui.HowToPlayPane;
import gui.MainMenuPane;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import sharedObject.RenderableHolder;

public class MainMenuScene extends Scene {
	private MainMenuPane mainMenuPane;
	private StackPane stackPane;
	private HowToPlayPane howToPlayPane;
	public static AnimationTimer startThemeSong;

	public MainMenuScene(final Parent root) {
		super(root);
	}

	public MainMenuScene() {
		this((Parent) new StackPane());
		this.setRoot((Parent) (this.stackPane = new StackPane()));
		
		startThemeSong = new AnimationTimer() {
			public void handle(long now) {
				if (!RenderableHolder.ThemeSong_music.isPlaying())
					RenderableHolder.ThemeSong_music.play();
			}
		};
		
		startThemeSong.start();

		this.mainMenuPane = new MainMenuPane();
		this.mainMenuPane.menuControlPane.howToPlayButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {

				RenderableHolder.ClickedSound_music.play();
				howToPlayPane.move();
			}
		});

		this.howToPlayPane = new HowToPlayPane();
		this.stackPane.getChildren().addAll(mainMenuPane, howToPlayPane);
	}

}
