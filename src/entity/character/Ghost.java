package entity.character;

import constant.Color;
import constant.Direction;
import constant.GameConstant;
import entity.base.Character;
import entity.base.ControlCharacter;
import entity.base.Entity;
import entity.base.Item;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import logic.GameLogic;

public class Ghost extends ControlCharacter {
	private boolean canEatPacMan;

	public Ghost(Color color) {
		super(color);
		this.name = GameConstant.GHOST_NAME;
		this.detail = GameConstant.GHOST_DETAIL;
		this.xPos = GameConstant.GHOST_SPAWN_X;
		this.yPos = GameConstant.GHOST_SPAWN_Y;
		setSpeed(GameConstant.GHOST_SPEED);
		setDirection(GameConstant.FIRST_GHOST_DIRECTION);
		setCanBeEaten(false);
		setCanEatPacMan(true);
	}

	public void die() {
		this.reborn();
	}

	protected void reborn() {
		this.xPos = GameConstant.GHOST_SPAWN_X;
		this.yPos = GameConstant.GHOST_SPAWN_Y;
		setSpeed(GameConstant.GHOST_SPEED);
		setDirection(GameConstant.FIRST_GHOST_DIRECTION);
		setCanBeEaten(false);
		setCanEatPacMan(true);
	}

	public void collideWith(Entity entity) {
		/*
		 * Check ��Ҫ��Ѻ���� ���Ѻ pacman: check ��ҡԹpacman�����? �Թ��: ���¡
		 * reborn �ͧpacman, ��ҧ�Ѿitem, �Թ�����: check ��Ҷ١�Թ�����? �١�Թ��:
		 * ���¡ die �١�Թ�����: �Թ��ҹ���� ���Ѻ item: setPower, ���¡��� item
		 */
	}

	public void update() {
		boolean alreadyTurned = false;
		for (Direction way : GameLogic.validWay()) {
			if ((way == Direction.NORTH && InputUtility.getSecondPlayerKeyPressed(KeyCode.UP))
					|| (way == Direction.EAST && InputUtility.getSecondPlayerKeyPressed(KeyCode.RIGHT))
					|| (way == Direction.SOUTH && InputUtility.getSecondPlayerKeyPressed(KeyCode.DOWN))
					|| (way == Direction.WEST && InputUtility.getSecondPlayerKeyPressed(KeyCode.LEFT))) {
				turn(way);
				alreadyTurned = true;
			}
			if (way == this.direction) {
				forward();
			}
			if (alreadyTurned) {
				break;
			}
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub

	}

	public boolean canEatPacMan() {
		return canEatPacMan;
	}

	public void setCanEatPacMan(boolean canEatPacMan) {
		this.canEatPacMan = canEatPacMan;
	}

}
