package entity.base;

import constant.CharacterColor;
import constant.Direction;
import logic.GameLogic;

public abstract class ControlCharacter extends Character {
	private CharacterColor color;

	public ControlCharacter(CharacterColor color) {
		super();
		setColor(color);
	}

	public CharacterColor getColor() {
		return color;
	}

	public void setColor(CharacterColor color) {
		this.color = color;
	}
}
