package entity.base;

import constant.Direction;
import constant.GameConstant;
import logic.GameLogic;

public abstract class Character extends Entity {
	protected double speed;
	protected Direction direction;
	private SpecialPower power;
	private boolean canBeEaten;
	private boolean isStarted;

	public Character() {
		super();
		this.setZ(10);
		setStarted(false);
	}

	protected void forward() {
		this.xPos += Math.sin(Math.toRadians(GameLogic.directionToInt(direction))) * this.speed;
		this.yPos -= Math.cos(Math.toRadians(GameLogic.directionToInt(direction))) * this.speed;
	}

	protected void turn(Direction direction) {
		this.setDirection(direction);
	}

	public abstract void die();

	protected abstract void reborn();

	public void checkWarp() {
		if (this.xPos == GameConstant.WARP_POINT_1_X && this.yPos <= GameConstant.WARP_POINT_1_Y) { // Up warp point
			this.setYPos(GameConstant.WARP_POINT_2_Y);
		} else if(this.xPos == GameConstant.WARP_POINT_1_X && this.yPos >= GameConstant.WARP_POINT_2_Y) { // Down warp point
			this.setYPos(GameConstant.WARP_POINT_1_Y);
		}
	}
	
	public abstract void collideWith(Entity entity);

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public SpecialPower getPower() {
		return power;
	}

	public void setPower(SpecialPower power) {
		this.power = power;
	}

	public boolean canBeEaten() {
		return canBeEaten;
	}

	public void setCanBeEaten(boolean canBeEaten) {
		this.canBeEaten = canBeEaten;
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}
}
