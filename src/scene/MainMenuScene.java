package scene;

import gui.MenuControlPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import sharedObject.RenderableHolder;

public class MainMenuScene extends BorderPane{
	private MenuControlPane menuControlPane;

	public MainMenuScene() {
		super();
		
		this.setPrefSize(900, 500);
		this.setStyle("-fx-background-color: midnightblue; ");
		
		this.menuControlPane = new MenuControlPane();
		this.setLeft(menuControlPane);
		// TODO Auto-generated constructor stub
		
	}
	
	
}
