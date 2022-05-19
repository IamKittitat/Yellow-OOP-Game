package entity.character;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import constant.Direction;
import constant.GameConstant;
import entity.base.Character;
import entity.base.Entity;
import gui.GameCanvas;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import logic.GameController;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class GhostBot extends Character {
	private boolean canEatPacMan;

	public GhostBot() {
		super();
		this.name = GameConstant.GHOST_BOT_NAME;
		this.xPos = GameConstant.GHOST_BOT_SPAWN_X;
		this.yPos = GameConstant.GHOST_BOT_SPAWN_Y;
		setSpeed(GameConstant.GHOST_BOT_SPEED);
		setDirection(GameConstant.FIRST_GHOST_BOT_DIRECTION);
		setCanBeEaten(false);
		setCanEatPacMan(true);
		setRadius(GameConstant.GHOST_BOT_RADIUS);
	}

	protected void forward() {
		this.xPos += Math.sin(Math.toRadians(GameLogic.directionToInt(direction))) * this.speed;
		this.yPos -= Math.cos(Math.toRadians(GameLogic.directionToInt(direction))) * this.speed;
	}

	protected void turn(Direction direction) {
		this.setDirection(direction);
	}

	public void die() {
		this.reborn();
	}

	@Override
	protected void reborn() {
		this.xPos = GameConstant.GHOST_BOT_SPAWN_X;
		this.yPos = GameConstant.GHOST_BOT_SPAWN_Y;
		setDirection(GameConstant.FIRST_GHOST_BOT_DIRECTION);
		setSpeed(GameConstant.GHOST_BOT_SPEED);
		setStarted(false);
		setCanBeEaten(false);
		setCanEatPacMan(true);
	}

	@Override
	public void collideWith(Entity entity) {
		if (entity instanceof PacMan) {
			if (canEatPacMan) {
				((Character) entity).die();
			} else {
				if (canBeEaten()) {
					this.die();
				}
			}
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		int state = ((int) GameCanvas.counter / 5) % 4;
		if (this.canBeEaten()) {
			switch (state) {
			case 0: {
				gc.drawImage(RenderableHolder.scaredGhostPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				return;
			}
			case 1: {
				gc.drawImage(RenderableHolder.scaredGhostPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				return;
			}
			case 2: {
				gc.drawImage(RenderableHolder.scaredGhostPNG2, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				return;
			}
			case 3: {
				gc.drawImage(RenderableHolder.scaredGhostPNG2, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				return;
			}
			default:
				gc.drawImage(RenderableHolder.scaredGhostPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
			}
		} else {
			switch (state) {
			case 0: {
				gc.drawImage(RenderableHolder.ghostBotPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				return;
			}
			case 1: {
				gc.drawImage(RenderableHolder.ghostBotPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				return;
			}
			case 2: {
				gc.drawImage(RenderableHolder.ghostBotPNG2, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				return;
			}
			case 3: {
				gc.drawImage(RenderableHolder.ghostBotPNG2, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
				return;
			}
			default:
				gc.drawImage(RenderableHolder.ghostBotPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
						this.radius * 2);
			}
		}
	}

	public void update() {
		this.checkWarp();
		// Stop GhostBot if GhostPlayer didn't give an input.
		if (!this.isStarted() && (InputUtility.getSecondPlayerKeyPressed() != null)) {
			this.setSpeed(GameConstant.GHOST_BOT_SPEED);
			this.moveOutFromSpawn();
		}

		if (this.isStarted()) {
			ArrayList<Direction> validWays = GameLogic.validWay(this.xPos, this.yPos, this.direction);
			Direction turnDirection = calculateDirection(validWays);
			if ((validWays.contains(turnDirection) && canTurn(validWays)) || (validWays.size() == 1)) {
				turn(turnDirection);
			}
			for (Direction way : validWays) {
				if (way == this.direction) {
					forward();
				}
			}
		}
	}

	private void moveOutFromSpawn() {
		this.forward();
		if (this.yPos == 156) { // to get out from spawn
			this.direction = Direction.WEST;
			if (this.xPos == 396) {
				this.setStarted(true);
			}
		}
	}

	// so bot wont move back and forth.
	public boolean canTurn(ArrayList<Direction> validWays) {
		if ((validWays.contains(Direction.NORTH) && validWays.contains(Direction.SOUTH))
				|| (validWays.contains(Direction.WEST) && validWays.contains(Direction.EAST))) {
			if (validWays.size() > 2) {
				return true;
			}
		} else {
			if (validWays.size() > 1) {
				return true;
			}
		}
		return false;
	}

	public Direction calculateDirection(ArrayList<Direction> validWays) {
		double pacManXPos = GameController.pacMan.getXPos();
		double pacManYPos = GameController.pacMan.getYPos();
		double ghostBotXPos = this.getXPos();
		double ghostBotYPos = this.getYPos();
		double diffX = ghostBotXPos - pacManXPos;
		double diffY = ghostBotYPos - pacManYPos;
		ArrayList<Direction> validTurnDirection = new ArrayList<Direction>();

		if ((diffX >= 0) && (diffY >= 0)) { // pacman up left
			if (validWays.contains(Direction.NORTH)) {
				validTurnDirection.add(Direction.NORTH);
			}
			if (validWays.contains(Direction.WEST)) {
				validTurnDirection.add(Direction.WEST);
			}
		} else if ((diffX <= 0) && (diffY >= 0)) { // pacman up right
			if (validWays.contains(Direction.NORTH)) {
				validTurnDirection.add(Direction.NORTH);
			}
			if (validWays.contains(Direction.EAST)) {
				validTurnDirection.add(Direction.EAST);
			}
		} else if ((diffX >= 0) && (diffY <= 0)) { // pacman down left
			if (validWays.contains(Direction.SOUTH)) {
				validTurnDirection.add(Direction.SOUTH);
			}
			if (validWays.contains(Direction.WEST)) {
				validTurnDirection.add(Direction.WEST);
			}
		} else if ((diffX <= 0) && (diffY <= 0)) { // pacman down right
			if (validWays.contains(Direction.SOUTH)) {
				validTurnDirection.add(Direction.SOUTH);
			}
			if (validWays.contains(Direction.EAST)) {
				validTurnDirection.add(Direction.EAST);
			}
		}
		if (validTurnDirection.size() > 0) {
			return randomFromValidTurnDirection(validTurnDirection);
		}
		int randomNum = ThreadLocalRandom.current().nextInt(0, validWays.size());
		return validWays.get(randomNum);
	}

	public Direction randomFromValidTurnDirection(ArrayList<Direction> validTurnDirection) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, validTurnDirection.size());
		return validTurnDirection.get(randomNum);

	}

	public boolean canEatPacMan() {
		return canEatPacMan;
	}

	public void setCanEatPacMan(boolean canEatPacMan) {
		this.canEatPacMan = canEatPacMan;
	}
}
