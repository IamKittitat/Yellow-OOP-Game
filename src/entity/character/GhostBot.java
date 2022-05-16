package entity.character;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import constant.Direction;
import constant.GameConstant;
import entity.base.Character;
import entity.base.Entity;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import logic.GameLogic;

public class GhostBot extends Character {
	private boolean canEatPacMan;

	public GhostBot() {
		super();
		this.name = GameConstant.GHOST_BOT_NAME;
		this.detail = GameConstant.GHOST_BOT_DETAIL;
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
		this.xPos = GameConstant.GHOST_SPAWN_X;
		this.yPos = GameConstant.GHOST_SPAWN_Y;
		setSpeed(GameConstant.GHOST_SPEED);
		setDirection(GameConstant.FIRST_GHOST_DIRECTION);
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

	public void update() {
		ArrayList<Direction> validWays = GameLogic.validWay(this.xPos, this.yPos);
		if (validWays.contains(this.direction)) {
//			System.out.println("update");
			forward();
		} else {
			int randomNum = ThreadLocalRandom.current().nextInt(0, validWays.size() - 1);
			System.out.println("turn");
			turn(validWays.get(randomNum));
		}

//		if ((this.canBeEaten() != LastCanBeEaten) && (this.canBeEaten() == true)) {
//			changeDirection();
//		}

		// update 1 time when can be eaten == true
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.GREEN);
		gc.fillRoundRect(xPos, yPos, 10, 10, 10, 10);
	}

	private void changeDirection() {
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
