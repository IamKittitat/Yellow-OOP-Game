package scene;

import gui.GameControlPane;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class BattleGameScene extends VBox{
	private GameControlPane gameControlPane;

	public BattleGameScene() {
		super();
		// TODO Auto-generated constructor stub
		this.setStyle("-fx-background-color: white;");
		this.setPrefSize(900, 500);
		this.setPadding(new Insets(10));
		
		this.gameControlPane = new GameControlPane();
		
		this.getChildren().add(gameControlPane);
	}

}
