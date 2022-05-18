package gui;

import java.util.ArrayList;

import constant.CharacterColor;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import sharedObject.RenderableHolder;

public class SwitchColorPane extends BorderPane {
	private ArrayList<Image> ColorImageList;
	private ArrayList<CharacterColor> ColorList;
	private int idx;
	private VBox nextButton;
	private VBox prevButton;

	public SwitchColorPane(ArrayList<Image> arrayImages,ArrayList<CharacterColor> arrayColors) {

		this.setColorImageList(arrayImages);
		this.setColorList(arrayColors);
		this.setPrefSize(600, 100);

		this.nextButton = new VBox();
		this.prevButton = new VBox();
		final Button nextBtn = new Button(">");
		final Button prevBtn = new Button("<");
		nextButton.getChildren().add(nextBtn);
		prevButton.getChildren().add(prevBtn);
		this.nextButton.setAlignment(Pos.CENTER);
		this.nextButton.setPadding(new Insets(50.0));
		this.prevButton.setAlignment(Pos.CENTER);
		this.prevButton.setPadding(new Insets(50.0));
		nextBtn.setFont(Font.font("Consolas", FontWeight.SEMI_BOLD, 30));
		prevBtn.setFont(Font.font("Consolas", FontWeight.SEMI_BOLD, 30));
		this.setLeft(prevButton);
		this.setRight(nextButton);
		this.change();
		nextBtn.setOnMouseClicked(e -> {
			idx = (idx + 1) % ColorList.size();
			change();
		});
		prevBtn.setOnMouseClicked(e -> {
			idx = (idx + 2) % ColorList.size();
			change();
		});

	}

	public void change() {
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
