package entity.item;

import constant.GameConstant;
import entity.base.Entity;
import entity.base.SpecialPower;
import javafx.scene.canvas.GraphicsContext;

public class ShieldPower extends SpecialPower{
	
	public ShieldPower(int x,int y) {
		super();
		this.name = "Shield Power";
		this.detail = "The Shield Power";
		setXPos(x);
		setYPos(y);
		setEaten(false);
		super.getEatenBy().add("PacMan");
		super.getEatenBy().add("Ghost");
		this.duration = GameConstant.SHIELD_BUFF_DURATION;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
	}

	@Override
	public void gainPower(Entity entity) {
		// pacman : canEatGhost;
		// ghost : canEatPacMan;
	}

	@Override
	public void clearPower(Entity entity) {
		// pacman : canEatGhost;
		// ghost : canEatPacMan;
	}
}
