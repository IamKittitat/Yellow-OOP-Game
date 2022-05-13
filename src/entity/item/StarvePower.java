package entity.item;

import constant.GameConstant;
import entity.base.Entity;
import entity.base.SpecialPower;
import javafx.scene.canvas.GraphicsContext;

public class StarvePower extends SpecialPower{
	
	public StarvePower(int x,int y) {
		super();
		this.name = GameConstant.STARVE_BUFF_NAME;
		this.detail = GameConstant.STARVE_BUFF_DETAIL;
		setXPos(x);
		setYPos(y);
		setEaten(false);
		super.getEatenBy().add("Ghost");
		this.duration = GameConstant.STARVE_BUFF_DURATION;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
	}

	@Override
	public void gainPower(Entity collector,Entity other) {
		// Set pacmanCanEatPellet = false
	}

	@Override
	public void clearPower(Entity collector,Entity other) {
		// Set pacmanCanEatPallet = true
	}
}
