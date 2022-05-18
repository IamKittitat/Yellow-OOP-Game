package scene;

import gui.BattleGamePane;
import gui.HowToPlayPane;
import gui.MainMenuPane;
import gui.MenuControlPane;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import sharedObject.RenderableHolder;

public class MainMenuScene extends Scene{
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
				// TODO Auto-generated method stub
				RenderableHolder.ClickedSound_music.play();
				howToPlayPane.enter();
			}
		});
		
		this.howToPlayPane = new HowToPlayPane();
		
		this.stackPane.getChildren().addAll(mainMenuPane,howToPlayPane);
	}
	
}
