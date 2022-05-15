package entity.item;

import java.util.ArrayList;

import constant.GameConstant;
import entity.base.Character;
import entity.base.SpecialPower;
import entity.character.Ghost;
import entity.character.PacMan;
import javafx.scene.canvas.GraphicsContext;

public class RevengePower extends SpecialPower {

	public RevengePower(int x, int y) {
		super();
		this.name = GameConstant.REVENGE_BUFF_NAME;
		this.detail = GameConstant.REVENGE_BUFF_DETAIL;
		this.xPos = x;
		this.yPos = y;
		setEaten(false);
		super.getEatenBy().add("PacMan");
		this.duration = GameConstant.REVENGE_BUFF_DURATION;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
	}

	@Override
	public void gainPower(Character collector, ArrayList<Character> other) {
		PacMan collectedPacMan = (PacMan) collector;
		collectedPacMan.setCanBeEaten(false);
		collectedPacMan.setCanEatGhost(true);

		for (Character otherCharacter : other) {
			Ghost otherGhost = (Ghost) otherCharacter;
			otherGhost.setCanBeEaten(true);
			otherGhost.setCanEatPacMan(false);
			otherGhost.setSpeed(duration);
		}

	}

	@Override
	public void clearPower(Character collector, ArrayList<Character> other) {
		PacMan collectedPacMan = (PacMan) collector;
		collectedPacMan.setCanBeEaten(true);
		collectedPacMan.setCanEatGhost(false);

		for (Character otherCharacter : other) {
			Ghost otherGhost = (Ghost) otherCharacter;
			otherGhost.setCanBeEaten(false);
			otherGhost.setCanEatPacMan(true);
			otherGhost.setSpeed(GameConstant.GHOST_SPEED);
		}
	}

}
