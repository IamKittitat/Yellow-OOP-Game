package entity.base;

import constant.Direction;
import logic.GameLogic;
import constant.CharacterColor;

public abstract class Character extends Entity {
	private CharacterColor color;
	protected int speed;
	protected Direction direction;
	private SpecialPower power;
	private boolean canBeEaten;

	public Character(CharacterColor color) {
		super();
		setColor(color);
	}
	
	protected abstract void forward();

	protected abstract void turn(Direction direction);
	
	public abstract void die();
	
	protected abstract void reborn();

	public abstract void collideWith(Entity entity);
	
	public CharacterColor getColor() {
		return color;
	}

	public void setColor(CharacterColor color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
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

}
