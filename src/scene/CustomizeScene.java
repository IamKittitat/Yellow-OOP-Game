package scene;

import gui.CustomizePane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class CustomizeScene extends Scene {
	private StackPane stackPane;

	public CustomizeScene(final Parent root) {
		super(root);
	}

	public CustomizeScene() {

		this((Parent) new StackPane());
		this.setRoot((Parent) (this.stackPane = new StackPane()));
		this.stackPane.getChildren().add(new CustomizePane());
	}
}
