package entity.character;

import constant.Color;
import constant.Direction;
import constant.GameConstant;
import entity.base.Character;
import entity.base.Entity;
import entity.base.SpecialPower;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

public class PacMan extends Character {
	private int life;
	private int score;
	private boolean canEatPellet;
	private boolean canEatGhost;

	public PacMan(Color color) {
		super(color);
		this.name = GameConstant.PACMAN_NAME;
		this.detail = GameConstant.PACMAN_DETAIL;
		this.xPos = GameConstant.PACMAN_SPAWN_X;
		this.yPos = GameConstant.PACMAN_SPAWN_Y;
		setSpeed(GameConstant.PACMAN_SPEED);
		setLife(GameConstant.PACMAN_LIFE);
		setScore(0);
		setPower(null);
		setDirection(GameConstant.FIRST_PACMAN_DIRECTION);
		setCanBeEaten(true);
		setCanEatGhost(false);
		setCanEatPellet(true);
	}

	private void forward() {
		this.xPos += Math.sin(Math.toRadians(this.direction)) * this.speed;
		this.yPos -= Math.cos(Math.toRadians(this.direction)) * this.speed;
	}

	private void turn(Direction direction) {
		this.setDirection(direction);
	}

	public boolean isDead() {
		return this.getLife() <= 0;
	}

	public void die() {
		this.setLife(this.getLife() - 1);
		if (this.getLife() <= 0) {
			// call endgame for pacman lose
			return;
		}
		this.reborn();
	}

	public void reborn() {
		this.xPos = GameConstant.PACMAN_SPAWN_X;
		this.yPos = GameConstant.PACMAN_SPAWN_Y;
		setSpeed(GameConstant.PACMAN_SPEED);
		setPower(null);
		setDirection(GameConstant.FIRST_PACMAN_DIRECTION);
		setCanBeEaten(false);
		setCanEatGhost(false);
		setCanEatPellet(true);
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

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub

	}
	
	public void update() {
		for(KeyCode nextKey : InputUtility.getFirstPlayerKeyPressed()) {
			if(validNextKey(nextKey)) {
				
			}
		}
		if (InputUtility.getKeyPressed(KeyCode.W)) {
			forward();
		}
		if (InputUtility.getKeyPressed(KeyCode.A)) {
			turn(true);
		} else if (InputUtility.getKeyPressed(KeyCode.D)) {
			turn(false);
		}

	}
	
	private boolean validNextKey(keyCode nextKey) {
		
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
