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
		// TODO Auto-generated constructor stub
		this.setStyle("-fx-background-color: black;");
		this.setPrefSize(900, 500);
		this.setMaxSize(900, 500);

		this.gameCanvas = new GameCanvas();
		this.gameControlPane = GameController.gameControlPane;
		
		this.endGamePane = new EndGamePane();

		this.addListerner();
		
		Pane gamePane = new VBox();
		
		gamePane.getChildren().addAll(gameControlPane, gameCanvas);
		gameCanvas.requestFocus();
		
		this.getChildren().addAll(gamePane,endGamePane);
	}
	
	public void addListerner() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});
	}

}
