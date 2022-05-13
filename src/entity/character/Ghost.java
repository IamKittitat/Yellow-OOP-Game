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
		 * 	ล้างบัพ
			Set ค่าใหม่
			เรียก reborn
		 */
	}

	public void reborn() {
		// setXPos,setYPos
	}

	public void collideWith(Entity entity) {
		/*
			Check ว่าชนกับอะไร
			ชนกับ pacman: check ว่ากินpacmanได้ไหม?
			กินได้: เรียก reborn ของpacman, ล้างบัพitem,
			กินไม่ได้: check ว่าถูกกินได้ไหม?
			ถูกกินได้: เรียก die
			ถูกกินไม่ได้: เดินผ่านไปเลย
			ชนกับ item: setPower, เรียกคสม item
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
