package scene;

import gui.BattleGamePane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class CustomiseScene extends Scene {
	private StackPane stackPane;

	public CustomiseScene(final Parent root) {
		super(root);

	}

	public CustomiseScene() {

		this((Parent) new StackPane());
		this.setRoot((Parent) (this.stackPane = new StackPane()));

	}
}
