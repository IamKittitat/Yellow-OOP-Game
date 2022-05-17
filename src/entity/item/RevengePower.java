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

public class RevengePower extends SpecialPower {

	public RevengePower(int x, int y,long startRandomSecondTime) {
		super(startRandomSecondTime);
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
		gc.setFill(Color.RED);
		gc.fillRoundRect(xPos, yPos, 5, 5, 5, 5);
	}

	@Override
	public void gainPower(Character collector, ArrayList<Character> other) {
//		System.out.println("Gain Revenge Power");
		setCollector(collector);
		setStartPowerSecondTime(System.nanoTime()/1000000000);
//		System.out.println(this.getStartPowerSecondTime());
		PacMan collectedPacMan = (PacMan) collector;
		collectedPacMan.setCanBeEaten(false);
		collectedPacMan.setCanEatGhost(true);

		for (Character otherCharacter : other) {
			Ghost otherGhost = (Ghost) otherCharacter;
			otherGhost.setCanBeEaten(true);
			otherGhost.setCanEatPacMan(false);
			otherGhost.setSpeed(GameConstant.DEBUFF_SPEED);
		}

	}

	@Override
	public void clearPower(ArrayList<Character> other) {
		PacMan collectedPacMan = (PacMan) collector;
		collectedPacMan.setCanBeEaten(true);
		collectedPacMan.setCanEatGhost(false);

		for (Character otherCharacter : other) {
			if(otherCharacter instanceof Ghost) {
				Ghost otherGhost = (Ghost) otherCharacter;
				otherGhost.setCanBeEaten(false);
				otherGhost.setCanEatPacMan(true);
				otherGhost.setSpeed(GameConstant.GHOST_SPEED);
			} else if(otherCharacter instanceof GhostBot) {
				GhostBot otherGhostBot = (GhostBot) otherCharacter;
				otherGhostBot.setCanBeEaten(false);
				otherGhostBot.setCanEatPacMan(true);
				otherGhostBot.setSpeed(GameConstant.GHOST_BOT_SPEED);
			}

		}
	}

}
