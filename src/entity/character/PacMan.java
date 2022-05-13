package entity.character;

import constant.Color;
import constant.GameConstant;
import entity.base.Character;
import entity.base.Entity;
import entity.base.SpecialPower;
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
		setXPos(GameConstant.PACMAN_SPAWN_X);
		setYPos(GameConstant.PACMAN_SPAWN_Y);
		setSpeed(GameConstant.PACMAN_SPEED);
		setLife(GameConstant.PACMAN_LIFE);
		setScore(0);
		setDirection(GameConstant.FIRST_PACMAN_DIRECTION);
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
		this.setLife(this.getLife() - 1);
		if( this.getLife() <= 0) {
			// call endgame for pacman lose
			return;
		}
		this.reborn();
	}

	public void reborn() {
		if(this.getPower() != null) {
			this.setPower(null);
		}

		setXPos(GameConstant.PACMAN_SPAWN_X);
		setYPos(GameConstant.PACMAN_SPAWN_Y);
		this.setDirection(GameConstant.FIRST_PACMAN_DIRECTION);
	}

	public void collideWith(Entity entity) {
		/*
		 * Check ��Ҫ��Ѻ���� ���Ѻ��: check ��ҡԹ�������? �Թ��: ���¡ reborn �ͧ��,
		 * ��ҧ�Ѿitem, �Թ�����: check ��Ҷ١�Թ�����? �١�Թ��: ���¡ die
		 * �١�Թ�����: �Թ��ҹ���� ���Ѻ Pellet: ������������ ����: ����
		 * score, ��� pellet �͡ �������: �Թ��ҹ ���Ѻ item: setPower, ���¡���
		 * item
		 * 
		 */
	}

	public void powerUp(SpecialPower specialPower) {
		specialPower.gainPower(getPower(), getPower());
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
