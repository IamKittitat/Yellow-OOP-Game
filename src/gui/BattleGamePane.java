package gui;

import input.InputUtility;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import logic.GameController;

public class BattleGamePane extends VBox {
	private GameControlPane gameControlPane;
	private GameCanvas gameCanvas;

	public BattleGamePane() {
		super();
		// TODO Auto-generated constructor stub
		this.setStyle("-fx-background-color: black;");
		this.setPrefSize(900, 500);
		this.setMaxSize(900, 500);

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
	}

}
