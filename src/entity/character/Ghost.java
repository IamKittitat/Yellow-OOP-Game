package entity.character;

import constant.Color;
import constant.GameConstant;
import entity.base.Character;
import entity.base.Entity;
import entity.base.Item;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

public class Ghost extends Character {
	private boolean canEatPacMan;

	public Ghost(Color color) {
		super(color);
		this.name = "Ghost";
		this.detail = "The Ghost";
		setXPos(GameConstant.GHOST_SPAWN_X);
		setYPos(GameConstant.GHOST_SPAWN_Y);
		setSpeed(GameConstant.GHOST_SPEED);
		setAngle(GameConstant.FIRST_GHOST_DIRECTION);
		setCanEatPacMan(false);
	}

	// MAY MOVE FORWARD, TURN TO CHARACTER CLASS OR INTERFACE
	private void forward() {
		// change x and y , with speed and angle
	}

	private void turn(KeyCode key) {
		// check direction of pacman
		// if not the same
		// change direction to key code map
	}

	public void die() {
		/*
		 * 	��ҧ�Ѿ
			Set �������
			���¡ reborn
		 */
	}

	public void reborn() {
		// setXPos,setYPos
	}

	public void collideWith(Entity entity) {
		/*
			Check ��Ҫ��Ѻ����
			���Ѻ pacman: check ��ҡԹpacman�����?
			�Թ��: ���¡ reborn �ͧpacman, ��ҧ�Ѿitem,
			�Թ�����: check ��Ҷ١�Թ�����?
			�١�Թ��: ���¡ die
			�١�Թ�����: �Թ��ҹ����
			���Ѻ item: setPower, ���¡��� item
		 */
	}

	public void powerUp(Item item) {
		// use item power (gainpower)
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
