package entity.item;

import java.util.ArrayList;

import constant.GameConstant;
import entity.base.Character;
import entity.base.SpecialPower;
import entity.character.Ghost;
import entity.character.GhostBot;
import entity.character.PacMan;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class RevengePower extends SpecialPower {

	public RevengePower(int x, int y, long startRandomSecondTime) {
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
		gc.drawImage(RenderableHolder.revengePNG, xPos - this.radius * 0.6, yPos - this.radius, this.radius * 1.2,
				this.radius * 2);
	}

	@Override
	public void gainPower(Character collector, ArrayList<Character> other) {
		setCollector(collector);
		setStartPowerSecondTime(System.nanoTime() / 1000000000);
		PacMan collectedPacMan = (PacMan) collector;
		collectedPacMan.setCanBeEaten(false);
		collectedPacMan.setCanEatGhost(true);
		collectedPacMan.setPower(this);

		for (Character otherCharacter : other) {
			if (otherCharacter instanceof Ghost) {
				Ghost otherGhost = (Ghost) otherCharacter;
				otherGhost.setCanBeEaten(true);
				otherGhost.setCanEatPacMan(false);
				otherGhost.setSpeed(GameConstant.DEBUFF_SPEED);
			} else if (otherCharacter instanceof GhostBot) {
				GhostBot otherGhost = (GhostBot) otherCharacter;
				otherGhost.setCanBeEaten(true);
				otherGhost.setCanEatPacMan(false);
				otherGhost.setSpeed(GameConstant.DEBUFF_SPEED);
			}
		}
	}

	@Override
	public void clearPower(ArrayList<Character> other) {
		PacMan collectedPacMan = (PacMan) collector;
		collectedPacMan.setCanBeEaten(true);
		collectedPacMan.setCanEatGhost(false);
		collectedPacMan.setPower(null);

		for (Character otherCharacter : other) {
			if (otherCharacter instanceof Ghost) {
				Ghost otherGhost = (Ghost) otherCharacter;
				otherGhost.setCanBeEaten(false);
				otherGhost.setCanEatPacMan(true);
				otherGhost.setSpeed(GameConstant.GHOST_SPEED);
			} else if (otherCharacter instanceof GhostBot) {
				GhostBot otherGhostBot = (GhostBot) otherCharacter;
				otherGhostBot.setCanBeEaten(false);
				otherGhostBot.setCanEatPacMan(true);
				otherGhostBot.setSpeed(GameConstant.GHOST_BOT_SPEED);
			}
		}
	}
}
