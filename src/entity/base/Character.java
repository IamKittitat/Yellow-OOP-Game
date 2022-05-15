package entity.base;

import constant.Direction;
import constant.Color;

public abstract class Character extends Entity {
	private Color color;
	protected int speed;
	protected int direction;
	private SpecialPower power;
	private boolean canBeEaten;

	public Character(Color color) {
		super();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		switch (direction) {
		case NORTH:
			this.direction = 0;
			break;
		case EAST:
			this.direction = 90;
			break;
		case SOUTH:
			this.direction = 180;
			break;
		case WEST:
			this.direction = 270;
			break;
		}
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

}
