package gui;

import java.util.ArrayList;

import constant.CharacterColor;
import gui.base.IconButton;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import sharedObject.RenderableHolder;

public class SwitchColorPane extends BorderPane {
	private ArrayList<Image> ColorImageList;
	private ArrayList<CharacterColor> ColorList;
	private int idx;
	private Button nextButton;
	private Button prevButton;

	public SwitchColorPane(ArrayList<Image> arrayImages, ArrayList<CharacterColor> arrayColors) {

		this.setColorImageList(arrayImages);
		this.setColorList(arrayColors);
		this.setPrefSize(600, 100);
		this.setPadding(new Insets(30, 100, 0, 100));

		this.initializeButton();
		this.change();

		this.setLeft(prevButton);
		this.setRight(nextButton);

	}

	private void initializeButton() {
		this.nextButton = new IconButton(RenderableHolder.nextButtonPNG);
		this.nextButton.setOnMouseClicked(e -> {
			RenderableHolder.ClickedSound_music.play();
			idx = (idx + 1) % ColorList.size();
			change();
		});

		this.prevButton = new IconButton(RenderableHolder.previousButtonPNG);
		this.prevButton.setOnMouseClicked(e -> {
			RenderableHolder.ClickedSound_music.play();
			idx = (idx + 2) % ColorList.size();
			change();
		});
	}

	private void change() {
		ImageView image = new ImageView(this.ColorImageList.get(idx));
		image.setFitWidth(100);
		image.setFitHeight(100);
		if (idx == 0) {
			image.setFitWidth(100);
			image.setFitHeight(100);
		}
		this.setCenter(image);
	}

	public ArrayList<Image> getColorImageList() {
		return ColorImageList;
	}

	public void setColorImageList(ArrayList<Image> colorImageList) {
		ColorImageList = colorImageList;
	}

	public ArrayList<CharacterColor> getColorList() {
		return ColorList;
	}

	public void setColorList(ArrayList<CharacterColor> colorList) {
		ColorList = colorList;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

}
