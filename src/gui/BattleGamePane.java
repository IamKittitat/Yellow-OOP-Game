package gui;

import input.InputUtility;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logic.GameController;

public class BattleGamePane extends StackPane {
	private GameControlPane gameControlPane;
	private GameCanvas gameCanvas;
	public static EndGamePane endGamePane;

	public BattleGamePane() {
		super();
		this.setStyle("-fx-background-color: black;");
		this.setPrefSize(912, 500);
		this.setMaxSize(912, 500);

		this.gameCanvas = new GameCanvas();
		this.gameControlPane = GameController.gameControlPane;
		BattleGamePane.endGamePane = new EndGamePane();

		Pane gamePane = new VBox();
		gamePane.getChildren().addAll(gameControlPane, gameCanvas);

		this.getChildren().addAll(gamePane, endGamePane);
		this.addListerner();

	}

	private void addListerner() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});
	}

}
