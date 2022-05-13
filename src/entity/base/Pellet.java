package entity.base;

import entity.character.PacMan;
import javafx.scene.canvas.GraphicsContext;

public class Pellet extends Item {

	public Pellet(int x, int y) {
		this.name = "Pellet";
		this.detail = "Favourite food for PacMan!";
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
