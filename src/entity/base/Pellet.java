package entity.base;

import constant.GameConstant;
import entity.character.PacMan;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class Pellet extends Item {

	public Pellet(int x, int y) {
		this.name = GameConstant.PELLET_NAME;
		this.detail = GameConstant.PELLET_DETAIL;
		this.xPos = x;
		this.yPos = y;
		setEaten(false);
		super.getEatenBy().add("PacMan");
		setRadius(GameConstant.PELLET_RADIUS);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillRect(xPos-this.radius, yPos-this.radius, this.radius*2, this.radius*2);
	}

}
