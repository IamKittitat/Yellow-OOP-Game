package entity.base;

import constant.CharacterColor;
import constant.Direction;
import javafx.scene.paint.Color;
import logic.GameLogic;

public abstract class ControlCharacter extends Character {
	private CharacterColor color;
	private boolean isStarted;

	public ControlCharacter(CharacterColor color) {
		super();
		setColor(color);
		setStarted(false);
	}

	protected void forward() {
		System.out.println("+x " + Math.sin(Math.toRadians(GameLogic.directionToInt(direction))));
		System.out.println("+y " + Math.cos(Math.toRadians(GameLogic.directionToInt(direction))));
		this.xPos += Math.sin(Math.toRadians(GameLogic.directionToInt(direction))) * this.speed;
		this.yPos -= Math.cos(Math.toRadians(GameLogic.directionToInt(direction))) * this.speed;
	}

	protected void turn(Direction direction) {
		this.setDirection(direction);
	}

	public CharacterColor getColor() {
		return color;
	}

	public void setColor(CharacterColor color) {
		this.color = color;
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}
}
