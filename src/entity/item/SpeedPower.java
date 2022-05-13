package entity.item;

import constant.GameConstant;
import entity.base.Entity;
import entity.base.SpecialPower;
import javafx.scene.canvas.GraphicsContext;

public class SpeedPower extends SpecialPower{
	
	public SpeedPower(int x,int y) {
		super();
		this.name = GameConstant.SPEED_BUFF_NAME;
		this.detail = GameConstant.SPEED_BUFF_DETAIL;
		setXPos(x);
		setYPos(y);
		setEaten(false);
		super.getEatenBy().add("PacMan");
		super.getEatenBy().add("Ghost");
		this.duration = GameConstant.SPEED_BUFF_DURATION;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
	}

	@Override
	public void gainPower(Entity collector,Entity other) {
		// Set pacmanSpeed += BUFF_SPEED

	}

	@Override
	public void clearPower(Entity collector,Entity other) {
		// Set pacmanSpeed = PACMAN_SPEED
	}
}
