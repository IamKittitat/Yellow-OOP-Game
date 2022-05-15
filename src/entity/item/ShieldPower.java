package entity.item;

import java.util.ArrayList;

import constant.GameConstant;
import entity.base.Character;
import entity.base.SpecialPower;
import entity.character.Ghost;
import entity.character.PacMan;
import javafx.scene.canvas.GraphicsContext;

public class ShieldPower extends SpecialPower {

	public ShieldPower(int x, int y) {
		super();
		this.name = GameConstant.SHIELD_BUFF_NAME;
		this.detail = GameConstant.SHIELD_BUFF_DETAIL;
		this.xPos = x;
		this.yPos = y;
		setEaten(false);
		super.getEatenBy().add("PacMan");
		super.getEatenBy().add("Ghost");
		this.duration = GameConstant.SHIELD_BUFF_DURATION;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
	}

	@Override
	public void gainPower(Character collector, ArrayList<Character> other) {
		if (collector instanceof PacMan) {
			PacMan collectedPacMan = (PacMan) collector;
			Ghost otherGhost = (Ghost) other.get(0);

			collectedPacMan.setCanBeEaten(false);
			otherGhost.setCanEatPacMan(false);
		} else if (collector instanceof Ghost) {
			Ghost collectedGhost = (Ghost) collector;
			PacMan otherPacMan = (PacMan) other.get(0);

			collectedGhost.setCanBeEaten(false);
			otherPacMan.setCanEatGhost(false);
		}
	}

	@Override
	public void clearPower(Character collector, ArrayList<Character> other) {
		if (collector instanceof PacMan) {
			PacMan collectedPacMan = (PacMan) collector;
			Ghost otherGhost = (Ghost) other.get(0);
			
			collectedPacMan.setCanBeEaten(true);
			otherGhost.setCanEatPacMan(true);
		} else if (collector instanceof Ghost) { //Not sure here
			Ghost collectedGhost = (Ghost) collector;
			PacMan otherPacMan = (PacMan) other.get(0);

			collectedGhost.setCanBeEaten(false);
			otherPacMan.setCanEatGhost(false);
		}
	}
}
