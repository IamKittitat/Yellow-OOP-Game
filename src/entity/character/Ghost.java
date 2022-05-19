package entity.character;

import java.util.ArrayList;

import constant.CharacterColor;
import constant.Direction;
import constant.GameConstant;
import entity.base.Character;
import entity.base.ControlCharacter;
import entity.base.Entity;

import entity.base.SpecialPower;
import entity.item.ShieldPower;
import gui.GameCanvas;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import logic.GameController;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class Ghost extends ControlCharacter {
	private boolean canEatPacMan;

	public Ghost(CharacterColor color) {
		super(color);
		this.name = GameConstant.GHOST_NAME;
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
			otherCharacter.add(GameController.pacMan);
			((SpecialPower) entity).gainPower(GameController.ghost, otherCharacter);
			((SpecialPower) entity).setRemoved(true);
			this.setPower((SpecialPower) entity);
		}
	}

	public void update() {
		// Stop Ghost if player didn't give an input.
		if (!this.isStarted() && (InputUtility.getSecondPlayerKeyPressed() != null)) {
			this.setSpeed(GameConstant.GHOST_SPEED);
			this.setStarted(true);
		}

		if (this.isStarted()) {
			ArrayList<Direction> validWays = GameLogic.validWay(this.xPos, this.yPos, this.direction);
			Direction turnDirection = GameLogic.KeyCodeToDirection(this.name, InputUtility.getSecondPlayerKeyPressed());
			this.checkWarp();
			if (validWays.contains(turnDirection)) {
				turn(turnDirection);
			}
			for (Direction way : validWays) {
				if (way == this.direction) {
					forward();
				}
			}
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		int state = ((int) GameCanvas.counter / 5) % 4;
		if (this.canBeEaten() && !this.canEatPacMan()) {
			switch (state) {
			case 0: {
				gc.drawImage(RenderableHolder.scaredGhostPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				break;
			}
			case 1: {
				gc.drawImage(RenderableHolder.scaredGhostPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				break;
			}
			case 2: {
				gc.drawImage(RenderableHolder.scaredGhostPNG2, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				break;
			}
			case 3: {
				gc.drawImage(RenderableHolder.scaredGhostPNG2, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				break;
			}
			default:
				gc.drawImage(RenderableHolder.scaredGhostPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
			}
		} else {
			switch (state) {
			case 0: {
				gc.drawImage(RenderableHolder.ghostPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				break;
			}
			case 1: {
				gc.drawImage(RenderableHolder.ghostPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				break;
			}
			case 2: {
				gc.drawImage(RenderableHolder.ghostPNG2, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				break;
			}
			case 3: {
				gc.drawImage(RenderableHolder.ghostPNG2, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				break;
			}
			default:
				gc.drawImage(RenderableHolder.ghostPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
			}
		}
		if(this.getPower() instanceof ShieldPower) {
			gc.drawImage(RenderableHolder.pacManShieldPNG, xPos -this.radius*1.5, yPos -this.radius*1.5, this.radius * 3, this.radius * 3);
		}
	}

	public boolean canEatPacMan() {
		return canEatPacMan;
	}

	public void setCanEatPacMan(boolean canEatPacMan) {
		this.canEatPacMan = canEatPacMan;
	}

}
