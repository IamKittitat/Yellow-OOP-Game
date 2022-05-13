package entity.character;

import constant.Color;
import constant.GameConstant;
import entity.base.Character;
import entity.base.Entity;
import entity.base.Item;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

public class PacMan extends Character {
	private int life;
	private int score;
	private boolean canEatPellet;
	private boolean canEatGhost;

	public PacMan(Color color) {
		super(color);
		this.name = "PacMan";
		this.detail = "The PacMan";
		setXPos(GameConstant.PACMAN_SPAWN_X);
		setYPos(GameConstant.PACMAN_SPAWN_Y);
		setSpeed(GameConstant.PACMAN_SPEED);
		setLife(GameConstant.PACMAN_LIFE);
		setScore(0);
		setAngle(GameConstant.FIRST_PACMAN_DIRECTION);
		setCanBeEaten(false);
		setCanEatGhost(false);
		setCanEatPellet(true);
	}

	private void forward() {
		// change x and y , with speed and angle
	}

	private void turn(KeyCode key) {
		// check direction of pacman
		// if not the same
		// change direction to key code map
	}

	public boolean isDead() {
		return this.getLife() <= 0;
	}

	public void die() {
		// ลด life
		// ถ้าชีวิตเหลือ 0 เรียก endGame pacman lose
		// ล้างบัพ
		// เรียก reborn
	}

	public void reborn() {
		// setXPos,setYPos
	}

	public void collideWith(Entity entity) {
		/*
		 * Check ว่าชนกับอะไร ชนกับผี: check ว่ากินผีได้ไหม? กินได้: เรียก reborn ของผี,
		 * ล้างบัพitem, กินไม่ได้: check ว่าถูกกินได้ไหม? ถูกกินได้: เรียก die
		 * ถูกกินไม่ได้: เดินผ่านไปเลย ชนกับ Pellet: เช็กว่าเก็บได้ไหม เก็บได้: เพิ่ม
		 * score, เอา pellet ออก เก็บไม่ได้: เดินผ่าน ชนกับ item: setPower, เรียกคสม
		 * item
		 * 
		 */
	}

	public void powerUp(Item item) {
		// use item power (gainpower)
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub

	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isCanEatPellet() {
		return canEatPellet;
	}

	public void setCanEatPellet(boolean canEatPellet) {
		this.canEatPellet = canEatPellet;
	}

	public boolean isCanEatGhost() {
		return canEatGhost;
	}

	public void setCanEatGhost(boolean canEatGhost) {
		this.canEatGhost = canEatGhost;
	}
}
