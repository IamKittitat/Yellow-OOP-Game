package entity.item;

import constant.GameConstant;
import entity.base.Entity;
import entity.base.SpecialPower;
import javafx.scene.canvas.GraphicsContext;

public class RevengePower extends SpecialPower{
	
	public RevengePower(int x,int y) {
		super();
		this.name = "Revenge Power";
		this.detail = "The Revenge Power";
		setXPos(x);
		setYPos(y);
		setEaten(false);
		super.getEatenBy().add("PacMan");
		this.duration = GameConstant.REVENGE_BUFF_DURATION;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
	}

	@Override
	public void gainPower(Entity entity) {
		// Set pacman  canBeEaten=false, canEatGhost=true
		// Decrease ghost speed
	}

	@Override
	public void clearPower(Entity entity) {
		// Set pacman  canBeEaten=true, canEatGhost=false
		// Increase ghost speed
	}
		
}
