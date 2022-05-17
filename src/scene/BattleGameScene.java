package scene;

import gui.BattleGamePane;
import gui.GameCanvas;
import gui.GameControlPane;
import input.InputUtility;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logic.GameController;

public class BattleGameScene extends Scene {

	private BattleGamePane battleGamePane;
	private StackPane stackPane;

	public BattleGameScene(final Parent root) {
		super(root);

	}

	public BattleGameScene() {
		this((Parent) new StackPane());
		this.setRoot((Parent) (this.stackPane = new StackPane()));

		this.battleGamePane = new BattleGamePane();
		this.stackPane.getChildren().add(battleGamePane);
	}

}
