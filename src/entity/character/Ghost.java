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
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class Ghost extends ControlCharacter {
	private boolean canEatPacMan;

	public Ghost(CharacterColor color) {
		super(color);
		this.name = GameConstant.GHOST_NAME;
		this.detail = GameConstant.GHOST_DETAIL;
		this.xPos = GameConstant.GHOST_SPAWN_X;
		this.yPos = GameConstant.GHOST_SPAWN_Y;
		setSpeed(GameConstant.GHOST_SPEED);
		setDirection(null);
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
		setDirection(null);
		setCanBeEaten(false);
		setCanEatPacMan(true);
	}

	public void collideWith(Entity entity) {
		if (entity instanceof PacMan) {
			if (canEatPacMan) {
				((Character) entity).die();
			} else {
				if (canBeEaten()) {
					this.die();
				}
			}
		} else if (entity instanceof SpecialPower) {
			this.setPower((SpecialPower) entity);
			System.out.println(this.getPower());
			// ((SpecialPower) entity).gainPower(null, null);
		}
	}

	public void update() {
		boolean alreadyTurned = false;
		for (Direction way : GameLogic.validWay(this.xPos,this.yPos)) {
			if ((way == Direction.NORTH && InputUtility.getSecondPlayerKeyPressed(KeyCode.I))
					|| (way == Direction.EAST && InputUtility.getSecondPlayerKeyPressed(KeyCode.L))
					|| (way == Direction.SOUTH && InputUtility.getSecondPlayerKeyPressed(KeyCode.K))
					|| (way == Direction.WEST && InputUtility.getSecondPlayerKeyPressed(KeyCode.J))) {
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
		gc.setFill(Color.PINK);
//		gc.fillRoundRect(xPos, yPos, 10, 10, 10, 10);
		gc.drawImage(RenderableHolder.ghostPNG, xPos-10, yPos-10,20,20);
	}

	public boolean canEatPacMan() {
		return canEatPacMan;
	}

	public void setCanEatPacMan(boolean canEatPacMan) {
		this.canEatPacMan = canEatPacMan;
	}

}
