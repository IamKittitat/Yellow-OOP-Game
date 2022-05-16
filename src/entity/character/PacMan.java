package entity.character;

import java.util.ArrayList;

import constant.CharacterColor;
import constant.Direction;
import constant.GameConstant;
import entity.base.Character;
import entity.base.ControlCharacter;
import entity.base.Entity;
import entity.base.Item;
import entity.base.Pellet;
import entity.base.SpecialPower;
import gui.GameCanvas;
import input.InputUtility;
import logic.GameLogic;
import sharedObject.RenderableHolder;
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
		setSpeed(0);
		setLife(GameConstant.PACMAN_LIFE);
		setScore(0);
		setPower(null);
		setDirection(Direction.EAST);
		setCanBeEaten(true);
		setCanEatGhost(false);
		setCanEatPellet(true);
		setRadius(GameConstant.PACMAN_RADIUS);
	}

	public boolean isDead() {
		return this.getLife() <= 0;
	}

	public void die() {
		System.out.println("life " + this.getLife());
		this.setLife(this.getLife() - 1);
		if (this.getLife() <= 0) {
			// call endgame
			return;
		}
		this.reborn();
	}

	protected void reborn() {
		this.xPos = GameConstant.PACMAN_SPAWN_X;
		this.yPos = GameConstant.PACMAN_SPAWN_Y;
		setSpeed(0);
		setStarted(false);
		setPower(null);
		setDirection(GameConstant.FIRST_PACMAN_DIRECTION);
		setCanBeEaten(true);
		InputUtility.setFirstPlayerKeyNull();
		setCanEatGhost(false);
		setCanEatPellet(true);
	}

	public void collideWith(Entity entity) {
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
				((Pellet) entity).setRemoved(true);
				this.setScore(this.getScore() + 1);
				System.out.println(this.getScore());				
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
		int state = ((int) GameCanvas.counter / 5) % 4;

		int angle = GameLogic.directionToInt(getDirection());
//
//		gc.translate(xPos+this.radius*2, yPos+this.radius*2);
//		gc.rotate(angle);

		switch (state) {
		case 0: {
			gc.drawImage(RenderableHolder.pacManPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
					this.radius * 2);
			break;
		}
		case 1: {
			gc.drawImage(RenderableHolder.pacManPNG2, xPos - this.radius, yPos - this.radius, this.radius * 2,
					this.radius * 2);
			break;
		}
		case 2: {
			gc.drawImage(RenderableHolder.pacManPNG3, xPos - this.radius, yPos - this.radius, this.radius * 2,
					this.radius * 2);
			break;
		}
		case 3: {
			gc.drawImage(RenderableHolder.pacManPNG4, xPos - this.radius, yPos - this.radius, this.radius * 2,
					this.radius * 2);
			break;
		}
		}
//		gc.translate(xPos, yPos);
//		gc.rotate(angle);
//		gc.setFill(Color.YELLOW);
//		int gunSize = (int) (this.radius / 5);
//		gc.fillRect(0, -gunSize, radius * 3 / 2, gunSize * 2);
//		gc.rotate(-angle);
//		gc.translate(-xPos, -yPos);
	}

	public void update() {
		boolean alreadyTurned = false;

		if (!this.isStarted() && (InputUtility.getFirstPlayerKeyPressed() != null)) {
			System.out.println("chc");
			this.setSpeed(GameConstant.PACMAN_SPEED);
			this.setStarted(true);
		}

		if (this.isStarted()) {
			ArrayList<Direction> validWays = GameLogic.validWay(this.xPos, this.yPos, this.direction);
//			System.out.println(validWays);
			Direction turnDirection = GameLogic.KeyCodeToDirection(this.name, InputUtility.getFirstPlayerKeyPressed());
			if (validWays.contains(turnDirection)) {
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
