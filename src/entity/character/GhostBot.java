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
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
//		gc.setFill(Color.GREEN);
//		gc.fillRoundRect(xPos-5, yPos-5, 10, 10, 10, 10);
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
		boolean alreadyTurned = false;
		this.checkWarp();
		if (!this.isStarted() && (InputUtility.getSecondPlayerKeyPressed() != null)) {
			this.setSpeed(GameConstant.GHOST_BOT_SPEED);
			this.moveOutFromSpawn();
		}

		if (this.isStarted()) {
			ArrayList<Direction> validWays = GameLogic.validWay(this.xPos, this.yPos, this.direction);
//			System.out.println(validWays);
			Direction turnDirection = calculateDirection(validWays);
//			System.out.println(this.direction);
//			System.out.println(turnDirection);
			if ((validWays.contains(turnDirection) && canTurn(validWays)) || (validWays.size() == 1)) {
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
//		if ((this.canBeEaten() != LastCanBeEaten) && (this.canBeEaten() == true)) {
//			changeDirection();
//		}

	}

	private void moveOutFromSpawn() {
		// TODO Auto-generated method stub
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

//		System.out.println(diffX + ", " + diffY);
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

	private void changeDirection() {
		System.out.println("change");
		if (this.direction == Direction.NORTH) {
			this.direction = Direction.SOUTH;
		} else if (this.direction == Direction.EAST) {
			this.direction = Direction.WEST;
		} else if (this.direction == Direction.SOUTH) {
			this.direction = Direction.NORTH;
		} else {
			this.direction = Direction.EAST;
		}
	}

	public boolean canEatPacMan() {
		return canEatPacMan;
	}

	public void setCanEatPacMan(boolean canEatPacMan) {
		this.canEatPacMan = canEatPacMan;
	}
}
