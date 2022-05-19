package scene;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneHolder {
	private Stage bindStage;

	public SceneHolder(final Stage bindStage) {
		this.bindStage = bindStage;
	}

	public void initialize() {
		this.switchScene(new MainMenuScene());
	}

	public void switchScene(final Scene nextScene) {
		this.bindStage.setResizable(false);
		this.bindStage.setScene(nextScene);
		this.bindStage.sizeToScene();

	}

}
