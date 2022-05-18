package entity.item;

import java.util.ArrayList;

import constant.GameConstant;
import entity.base.Character;
import entity.base.SpecialPower;
import entity.character.Ghost;
import entity.character.GhostBot;
import entity.character.PacMan;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class ShieldPower extends SpecialPower {

	public ShieldPower(int x, int y, long startRandomSecondTime) {
		super(startRandomSecondTime);
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
		gc.drawImage(RenderableHolder.shieldPNG, xPos - this.radius, yPos - this.radius, this.radius * 2,
				this.radius * 2);
	}

	@Override
	public void gainPower(Character collector, ArrayList<Character> other) {
		System.out.println("Gain Shield Power");
		setCollector(collector);
		setStartPowerSecondTime(System.nanoTime() / 1000000000);
//		System.out.println(this.getStartPowerSecondTime());
		if (collector instanceof PacMan) {
			PacMan collectedPacMan = (PacMan) collector;
			collectedPacMan.setCanBeEaten(false);
			for(Character otherCharacter : other) {
				if(otherCharacter instanceof Ghost) {
					Ghost otherGhost = (Ghost) otherCharacter;					
					otherGhost.setCanEatPacMan(false);
				} else if(otherCharacter instanceof GhostBot) {
					GhostBot otherGhost = (GhostBot) otherCharacter;
					otherGhost.setCanEatPacMan(false);
				}
			}
		} else if (collector instanceof Ghost) {
			Ghost collectedGhost = (Ghost) collector;
			PacMan otherPacMan = (PacMan) other.get(0);

			collectedGhost.setCanBeEaten(false);
			otherPacMan.setCanEatGhost(false);
		}
	}

	@Override
	public void clearPower(ArrayList<Character> other) {
//		System.out.println("clear shield");
		if (collector instanceof PacMan) {
			PacMan collectedPacMan = (PacMan) collector;
			Ghost otherGhost = (Ghost) other.get(0);

			collectedPacMan.setCanBeEaten(true);
			otherGhost.setCanEatPacMan(true);
		} else if (collector instanceof Ghost) { // Not sure here
			Ghost collectedGhost = (Ghost) collector;
			PacMan otherPacMan = (PacMan) other.get(0);

			collectedGhost.setCanBeEaten(false);
			otherPacMan.setCanEatGhost(false);
		}
	}
}
