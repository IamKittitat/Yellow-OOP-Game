package gui.base;

import sharedObject.RenderableHolder;

public class TextButton extends GameButton {

	public TextButton(String arg0) {
		super(arg0);
		this.setPrefWidth(300);
		this.setPrefHeight(50);
		this.setStyle("-fx-background-color: transparent; "
		+"-fx-border-color: yellow; " 
				+ "-fx-border-radius: 30;"
		+"-fx-text-fill: yellow;"
				+" -fx-border-width: 2px;"
		+"-fx-font-weight: 300;"
				+"-fx-font-size:20;");
	}



}
