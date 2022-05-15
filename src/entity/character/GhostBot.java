package entity.character;

import constant.Color;
import constant.Direction;
import constant.GameConstant;
import entity.base.Character;
import entity.base.Entity;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import logic.GameLogic;

public class GhostBot extends Character {
	private boolean canEatPacMan;

	public GhostBot(Color color) {
		super(color);
		this.name = GameConstant.GHOST_BOT_NAME;
		this.detail = GameConstant.GHOST_BOT_DETAIL;
		this.xPos = GameConstant.GHOST_BOT_SPAWN_X;
		this.yPos = GameConstant.GHOST_BOT_SPAWN_Y;
		setSpeed(GameConstant.GHOST_BOT_SPEED);
		setDirection(GameConstant.FIRST_GHOST_BOT_DIRECTION);
		setCanBeEaten(false);
		setCanEatPacMan(true);
	}

	@Override
	protected void forward() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void turn(Direction direction) {
		// TODO Auto-generated method stub

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

	}

	@Override
	public void collideWith(Entity entity) {
		/*
		 * Check ว่าชนกับอะไร ชนกับ pacman: check ว่ากินpacmanได้ไหม? กินได้: เรียก
		 * reborn ของpacman, ล้างบัพitem, กินไม่ได้: check ว่าถูกกินได้ไหม? ถูกกินได้:
		 * เรียก die ถูกกินไม่ได้: เดินผ่านไปเลย ชนกับ item: setPower, เรียกคสม item
		 */
	}

	public void update() {
//		boolean alreadyTurned = false;
//		for (Direction way : GameLogic.validWay()) {
//			if ((way == Direction.NORTH && InputUtility.getSecondPlayerKeyPressed(KeyCode.UP))
//					|| (way == Direction.EAST && InputUtility.getSecondPlayerKeyPressed(KeyCode.RIGHT))
//					|| (way == Direction.SOUTH && InputUtility.getSecondPlayerKeyPressed(KeyCode.DOWN))
//					|| (way == Direction.WEST && InputUtility.getSecondPlayerKeyPressed(KeyCode.LEFT))) {
//				turn(way);
//				alreadyTurned = true;
//			}
//			if(way == this.direction) {
//				forward();
//			}			
//			if(alreadyTurned) {
//				break;
//			}
//		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub

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
