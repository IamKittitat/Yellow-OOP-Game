package scene;

import gui.BattleGamePane;
import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import sharedObject.RenderableHolder;

public class BattleGameScene extends Scene {

	private BattleGamePane battleGamePane;
	private StackPane stackPane;
	public static AnimationTimer startPlayingSong;

	public BattleGameScene(final Parent root) {
		super(root);

	}

	public BattleGameScene() {
		this((Parent) new StackPane());
		this.setRoot((Parent) (this.stackPane = new StackPane()));
		RenderableHolder.ThemeSong_music.stop();
		MainMenuScene.startThemeSong.stop();
		
		startPlayingSong = new AnimationTimer() {
			public void handle(long now) {
				if (!RenderableHolder.Playing_music.isPlaying())
					RenderableHolder.Playing_music.play();
			}
		};
		startPlayingSong.start();

		this.battleGamePane = new BattleGamePane();
		this.stackPane.getChildren().add(battleGamePane);
	}

}
