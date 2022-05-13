package entity.base;

import constant.GameConstant;
import entity.character.PacMan;
import javafx.scene.canvas.GraphicsContext;

public class Pellet extends Item {

	public Pellet(int x, int y) {
		this.name = GameConstant.PELLET_NAME;
		this.detail = GameConstant.PELLET_DETAIL;
		setXPos(x);
		setYPos(y);
		setEaten(false);
		super.getEatenBy().add("PacMan");
	}
	

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub

	}

}
