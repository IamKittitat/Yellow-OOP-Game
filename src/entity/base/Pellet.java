package entity.base;

import constant.GameConstant;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pellet extends Item {

	public Pellet(int x, int y) {
		this.name = GameConstant.PELLET_NAME;
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
