package gui.base;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IconButton extends GameButton {
	private ImageView iconImageView;

	public IconButton(Image iconImage) {
		super();
		this.iconImageView = new ImageView(iconImage);
		this.setGraphic(iconImageView);
		this.setStyle("-fx-background-color: transparent; ");
	}
	
}
