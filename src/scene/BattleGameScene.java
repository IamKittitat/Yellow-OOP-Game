package scene;

import gui.BattleGamePane;
import gui.GameCanvas;
import gui.GameControlPane;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logic.GameController;
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
		RenderableHolder.ThemeSong_music.stop();
		MainMenuScene.startThemeSong.stop();
		this.setRoot((Parent) (this.stackPane = new StackPane()));
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
