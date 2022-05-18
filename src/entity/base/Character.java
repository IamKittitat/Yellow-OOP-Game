package entity.base;

import constant.Direction;
import logic.GameLogic;
import constant.CharacterColor;

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

	protected abstract void forward();

	protected abstract void turn(Direction direction);

	public abstract void die();

	protected abstract void reborn();

	public void checkWarp() {
		if (this.xPos == 468 && this.yPos <= -12) {
			this.setYPos(444);
		} else if(this.xPos == 468 && this.yPos >= 444) {
			this.setYPos(-12);
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
