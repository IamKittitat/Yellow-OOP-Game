package gui;

import javafx.scene.layout.BorderPane;

public class MainMenuPane extends BorderPane {
	public MenuControlPane menuControlPane;

	public MainMenuPane() {
		super();

		this.setPrefSize(900, 500);
		this.setStyle("-fx-background-color: midnightblue; ");

		this.menuControlPane = new MenuControlPane();
		this.setLeft(menuControlPane);
		// TODO Auto-generated constructor stub

	}
}
