package entity.character;

import constant.CharacterColor;
import constant.Direction;
import constant.GameConstant;
import entity.base.Character;
import entity.base.ControlCharacter;
import entity.base.Entity;
import entity.base.Item;
import entity.base.Pellet;
import entity.base.SpecialPower;
import input.InputUtility;
import logic.GameLogic;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;

public class PacMan extends ControlCharacter {
	private int life;
	private int score;
	private boolean canEatPellet;
	private boolean canEatGhost;

	public PacMan(CharacterColor color) {
		super(color);
		this.name = GameConstant.PACMAN_NAME;
		this.detail = GameConstant.PACMAN_DETAIL;
		this.xPos = GameConstant.PACMAN_SPAWN_X;
		this.yPos = GameConstant.PACMAN_SPAWN_Y;
		setSpeed(GameConstant.PACMAN_SPEED);
		setLife(GameConstant.PACMAN_LIFE);
		setScore(0);
		setPower(null);
		setDirection(null);
		setCanBeEaten(true);
		setCanEatGhost(false);
		setCanEatPellet(true);
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

	protected void reborn() {
		this.xPos = GameConstant.PACMAN_SPAWN_X;
		this.yPos = GameConstant.PACMAN_SPAWN_Y;
		setSpeed(GameConstant.PACMAN_SPEED);
		setPower(null);
		setDirection(null);
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
		if ((entity instanceof Ghost) || (entity instanceof GhostBot)) {
			if (canEatGhost) {
				((Character) entity).die();
			} else {
				if (canBeEaten()) {
					this.die();
				}
			}
		} else if (entity instanceof Pellet) {
			if (canEatPellet) {
				this.setScore(this.getScore() + 1);
			}
		} else if (entity instanceof SpecialPower) {
			this.setPower((SpecialPower) entity);
			System.out.println(this.getPower());
			// ((SpecialPower) entity).gainPower(null, null);
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.YELLOW);
		gc.fillArc(xPos, yPos, 10, 10, 45, 300, ArcType.ROUND);
	}

	public void update() {
		boolean alreadyTurned = false;
		for (Direction way : GameLogic.validWay()) {
			if ((way == Direction.NORTH && InputUtility.getFirstPlayerKeyPressed(KeyCode.W))
					|| (way == Direction.EAST && InputUtility.getFirstPlayerKeyPressed(KeyCode.D))
					|| (way == Direction.SOUTH && InputUtility.getFirstPlayerKeyPressed(KeyCode.S))
					|| (way == Direction.WEST && InputUtility.getFirstPlayerKeyPressed(KeyCode.A))) {
				this.turn(way);
				alreadyTurned = true;
			}
			if (way == this.direction) {
				this.forward();
			}
			if (alreadyTurned) {
				break;
			}
		}
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
