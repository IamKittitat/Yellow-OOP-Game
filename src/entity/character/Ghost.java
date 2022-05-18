package entity.character;

import java.util.ArrayList;

import constant.CharacterColor;
import constant.Direction;
import constant.GameConstant;
import entity.base.Character;
import entity.base.ControlCharacter;
import entity.base.Entity;
import entity.base.Item;
import entity.base.Pellet;
import entity.base.SpecialPower;
import gui.GameCanvas;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import logic.GameController;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class Ghost extends ControlCharacter {
	private boolean canEatPacMan;

	public Ghost(CharacterColor color) {
		super(color);
		this.name = GameConstant.GHOST_NAME;
		this.detail = GameConstant.GHOST_DETAIL;
		this.xPos = GameConstant.GHOST_SPAWN_X;
		this.yPos = GameConstant.GHOST_SPAWN_Y;
		setSpeed(GameConstant.GHOST_SPEED);
		setDirection(null);
		setCanBeEaten(false);
		setCanEatPacMan(true);
		setRadius(GameConstant.GHOST_RADIUS);
	}

	public void die() {
		this.reborn();
	}

	protected void reborn() {
		this.xPos = GameConstant.GHOST_SPAWN_X;
		this.yPos = GameConstant.GHOST_SPAWN_Y;
		setSpeed(GameConstant.GHOST_SPEED);
		setStarted(false);
		setDirection(GameConstant.FIRST_GHOST_DIRECTION);
		InputUtility.setSecondPlayerKeyNull();
		setCanBeEaten(false);
		setCanEatPacMan(true);
	}

	public void collideWith(Entity entity) {
		if (entity instanceof PacMan) {
			if (canEatPacMan) {
				((Character) entity).die();
			} else {
				if (canBeEaten()) {
					this.die();
				}
			}
		} else if (entity instanceof SpecialPower) {
			ArrayList<Character> otherCharacter = new ArrayList<Character>();
			otherCharacter.add(GameController.pacMan); // fixed here
			((SpecialPower) entity).gainPower(GameController.ghost,otherCharacter);
			((SpecialPower) entity).setRemoved(true);
			this.setPower((SpecialPower) entity);
			System.out.println("ghost, " + this.getPower().getName());
			// ((SpecialPower) entity).gainPower(null, null);
		}
	}

	public void update() {
		boolean alreadyTurned = false;

		if (!this.isStarted() && (InputUtility.getSecondPlayerKeyPressed() != null)) {
			this.setSpeed(GameConstant.GHOST_SPEED);
			this.setStarted(true);
		}

		if (this.isStarted()) {
			ArrayList<Direction> validWays = GameLogic.validWay(this.xPos, this.yPos, this.direction);
//			System.out.println(validWays);
			Direction turnDirection = GameLogic.KeyCodeToDirection(this.name, InputUtility.getSecondPlayerKeyPressed());
			this.checkWarp();
			if (validWays.contains(turnDirection)) {
				turn(turnDirection);
				alreadyTurned = true;
			}
			for (Direction way : validWays) {
//				System.out.println(way);
//				System.out.println("direction " + this.direction);
				if (way == this.direction) {
					forward();
//					System.out.println("forward");
				}
			}
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
//		gc.drawImage(RenderableHolder.ghostPNG, xPos-10, yPos-10,20,20);
		int state = ((int) GameCanvas.counter / 5) % 4;
		switch (state) {
		case 0: {
			gc.drawImage(RenderableHolder.ghostPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
					this.radius * 2);
			return;
		}
		case 1: {
			gc.drawImage(RenderableHolder.ghostPNG2, xPos - this.radius, yPos - this.radius, this.radius * 2,
					this.radius * 2);
			return;
		}
		case 2: {
			gc.drawImage(RenderableHolder.ghostPNG3, xPos - this.radius, yPos - this.radius, this.radius * 2,
					this.radius * 2);
			return;
		}
		case 3: {
			gc.drawImage(RenderableHolder.ghostPNG4, xPos - this.radius, yPos - this.radius, this.radius * 2,
					this.radius * 2);
			return;
		}
		default:
			gc.drawImage(RenderableHolder.ghostPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
					this.radius * 2);
		}
	}

	public boolean canEatPacMan() {
		return canEatPacMan;
	}

	public void setCanEatPacMan(boolean canEatPacMan) {
		this.canEatPacMan = canEatPacMan;
	}

}
