package entity.base;

import constant.Color;
import constant.Direction;
import logic.GameLogic;

public abstract class ControlCharacter extends Character{

	public ControlCharacter(Color color) {
		super(color);
	}
	
	protected void forward() {
		this.xPos += Math.sin(Math.toRadians(GameLogic.directionToInt(direction))) * this.speed;
		this.yPos -= Math.cos(Math.toRadians(GameLogic.directionToInt(direction))) * this.speed;
	}

	protected void turn(Direction direction) {
		this.setDirection(direction);
	}
}