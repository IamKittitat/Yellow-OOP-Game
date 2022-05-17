package scene;

import gui.GameCanvas;
import gui.GameControlPane;
import input.InputUtility;
import javafx.geometry.Insets;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import logic.GameController;

public class BattleGameScene extends VBox {
	private GameControlPane gameControlPane;
	private GameCanvas gameCanvas;

	public BattleGameScene() {
		super();
		// TODO Auto-generated constructor stub
		this.setStyle("-fx-background-color: white;");
		this.setPrefSize(900, 500);

		this.gameCanvas = new GameCanvas();
		this.gameControlPane = GameController.gameControlPane;

		this.addListerner();

		this.getChildren().addAll(gameControlPane, gameCanvas);
		gameCanvas.requestFocus();

	}

	public void addListerner() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);

		});
		this.setOnMousePressed((MouseEvent event) -> {
			System.out.println("mouse pressed");
		});
	}

}
