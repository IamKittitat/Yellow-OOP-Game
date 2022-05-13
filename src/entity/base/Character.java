package entity.base;

import constant.Direction;
import constant.Color;

public abstract class Character extends Entity {
	private Color color;
	private int speed;
	private int angle;
	private Item power;
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

	public int getAngle() {
		return angle;
	}

	public void setAngle(Direction angle) {
		switch (angle) {
		case NORTH:
			this.angle = 0;
			break;
		case EAST:
			this.angle = 90;
			break;
		case SOUTH:
			this.angle = 180;
			break;
		case WEST:
			this.angle = 270;
			break;
		}
	}

	public Item getPower() {
		return power;
	}

	public void setPower(Item power) {
		this.power = power;
	}

	public boolean canBeEaten() {
		return canBeEaten;
	}

	public void setCanBeEaten(boolean canBeEaten) {
		this.canBeEaten = canBeEaten;
	}

}
