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
import entity.item.ShieldPower;
import gui.GameCanvas;
import input.InputUtility;
import logic.GameController;
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
		this.xPos = GameConstant.PACMAN_SPAWN_X;
		this.yPos = GameConstant.PACMAN_SPAWN_Y;
		setSpeed(0);
		setLife(GameConstant.PACMAN_LIFE);
		setScore(0);
		setPower(null);
		setDirection(GameConstant.FIRST_PACMAN_DIRECTION);
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
		ArrayList<Integer> randomPosition = GameLogic.randomPosition();
		this.xPos = randomPosition.get(0);
		this.yPos = randomPosition.get(1);
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
			if (canEatGhost && ((Character) entity).canBeEaten()) {
				((Character) entity).die();
				RenderableHolder.PacManEatGhost_music.play();
			} else {
				if(entity instanceof Ghost) {
					if (canBeEaten() || ((Ghost) entity).canEatPacMan()) {
						this.die();
						RenderableHolder.PacManDie_music.play();
					}
				} else if (entity instanceof GhostBot) {
					if (canBeEaten() || ((GhostBot) entity).canEatPacMan()) {
						this.die();
						RenderableHolder.PacManDie_music.play();
					}
				}
				
			}
		} else if (entity instanceof Pellet) {
			if (canEatPellet) {
				((Pellet) entity).setRemoved(true);
//				RenderableHolder.EatPellet_music.play();
				this.setScore(this.getScore() + 1);
				System.out.println(this.getScore());
			}
		} else if (entity instanceof SpecialPower) {
			ArrayList<Character> otherCharacter = new ArrayList<Character>();
			RenderableHolder.CollectPower_music.play();
			otherCharacter.add(GameController.ghost); // fixed here
			otherCharacter.add(GameController.ghostBot1);
			((SpecialPower) entity).gainPower(GameController.pacMan, otherCharacter);
			((SpecialPower) entity).setRemoved(true);
			this.setPower((SpecialPower) entity);
			System.out.println(this.getPower().getName());
			// ((SpecialPower) entity).gainPower(null, null);
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		int state = ((int) GameCanvas.counter / 5) % 4;

		int angle = GameLogic.directionToInt(getDirection()) + 270; // plus for make east =0;
//		System.out.println(angle);
		gc.translate(xPos, yPos);
		gc.rotate(angle);
		switch (state) {
		case 0: {
//			gc.drawImage(RenderableHolder.pacManPNG1, xPos - this.radius, yPos - this.radius, this.radius * 2,
//					this.radius * 2);
			gc.drawImage(RenderableHolder.pacManPNG1, -this.radius, -this.radius, this.radius * 2, this.radius * 2);

			break;
		}
		case 1: {
			gc.drawImage(RenderableHolder.pacManPNG2, -this.radius, -this.radius, this.radius * 2, this.radius * 2);
			break;
		}
		case 2: {
			gc.drawImage(RenderableHolder.pacManPNG3, -this.radius, -this.radius, this.radius * 2, this.radius * 2);
			break;
		}
		case 3: {
			gc.drawImage(RenderableHolder.pacManPNG4, -this.radius, -this.radius, this.radius * 2, this.radius * 2);
			break;
		}
		}
		if(this.getPower() instanceof ShieldPower) {
			gc.drawImage(RenderableHolder.pacManShieldPNG, -this.radius*1.5, -this.radius*1.5, this.radius * 3, this.radius * 3);
		}
		if(this.CanEatPellet() == false) {
			gc.drawImage(RenderableHolder.pacManStarvePNG, -this.radius, -this.radius, this.radius * 2, this.radius * 2);
		}
//		gc.translate(xPos, yPos);
//		gc.rotate(angle);
//		gc.setFill(Color.YELLOW);
//		int gunSize = (int) (this.radius / 5);
//		gc.fillRect(0, -gunSize, radius * 3 / 2, gunSize * 2);
		gc.rotate(-angle);
		gc.translate(-xPos, -yPos);
	}

	public void update() {
		boolean alreadyTurned = false;
//		System.out.println(xPos + ", "+yPos);
		if (!this.isStarted() && (InputUtility.getFirstPlayerKeyPressed() != null)) {
			System.out.println("chc");
			this.setSpeed(GameConstant.PACMAN_SPEED);
			this.setStarted(true);
		}

		if (this.isStarted()) {
			ArrayList<Direction> validWays = GameLogic.validWay(this.xPos, this.yPos, this.direction);
//			System.out.println(validWays);
//			System.out.println(validWays);
			Direction turnDirection = GameLogic.KeyCodeToDirection(this.name, InputUtility.getFirstPlayerKeyPressed());

			this.checkWarp();
			if (validWays.contains(turnDirection)) {
//				System.out.println(turnDirection);
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

	public boolean CanEatPellet() {
		return canEatPellet;
	}

	public void setCanEatPellet(boolean canEatPellet) {
		this.canEatPellet = canEatPellet;
	}

	public boolean canEatGhost() {
		return canEatGhost;
	}

	public void setCanEatGhost(boolean canEatGhost) {
		this.canEatGhost = canEatGhost;
	}
}
