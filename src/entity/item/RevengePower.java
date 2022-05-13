package entity.item;

import constant.GameConstant;
import entity.base.Entity;
import entity.base.SpecialPower;
import entity.character.PacMan;
import javafx.scene.canvas.GraphicsContext;

public class RevengePower extends SpecialPower{
	
	public RevengePower(int x,int y) {
		super();
		this.name = GameConstant.REVENGE_BUFF_NAME;
		this.detail = GameConstant.REVENGE_BUFF_DETAIL;
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
	public void gainPower(Entity collector,Entity other) {
		PacMan pacMan = (PacMan) collector;
		
		// Set pacman  canBeEaten=false, canEatGhost=true
		// Decrease ghost speed
	}

	@Override
	public void clearPower(Entity collector,Entity other) {
		// Set pacman  canBeEaten=true, canEatGhost=false
		// Increase ghost speed
	}
		
}
