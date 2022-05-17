package scene;

import gui.BattleGamePane;
import gui.HowToPlayPane;
import gui.MainMenuPane;
import gui.MenuControlPane;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import sharedObject.RenderableHolder;

public class MainMenuScene extends Scene{
	private MainMenuPane mainMenuPane;
	private StackPane stackPane;
	private HowToPlayPane howToPlayPane;
	
	public MainMenuScene(final Parent root) {
		super(root);

	}
	
	public MainMenuScene() {
		this((Parent) new StackPane());
		this.setRoot((Parent) (this.stackPane = new StackPane()));

		this.mainMenuPane = new MainMenuPane();
		this.mainMenuPane.menuControlPane.howToPlayButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				howToPlayPane.enter();
			}
		});
		
		this.howToPlayPane = new HowToPlayPane();
		
		this.stackPane.getChildren().addAll(mainMenuPane,howToPlayPane);
	}
	
}
