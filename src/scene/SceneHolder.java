package scene;


import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneHolder {
	private Stage bindStage;
	public BattleGameScene mainMenuScene;

	// public PlayMenuScene playMenuScene;
	public SceneHolder(final Stage bindStage) {
		this.bindStage = bindStage;
	}

	public void initialize() {
		this.switchScene(new Scene(this.mainMenuScene = new BattleGameScene()));
	}

	public void switchScene(final Scene nextScene) {
		this.bindStage.setResizable(false);
		this.bindStage.setScene(nextScene);
		this.bindStage.sizeToScene();

	}

}
