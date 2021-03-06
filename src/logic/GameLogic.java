package logic;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import constant.CharacterColor;
import constant.Direction;
import constant.GameConstant;
import entity.base.Map;
import entity.base.PelletHolder;
import entity.base.SpecialPower;
import entity.base.SpecialPowerHolder;
import entity.character.PacMan;
import entity.item.RevengePower;
import entity.item.ShieldPower;
import entity.item.StarvePower;
import gui.GameCanvas;
import input.InputUtility;
import javafx.scene.input.KeyCode;
import sharedObject.RenderableHolder;

public class GameLogic {
	public static int counter = 0;
	public static CharacterColor pacManColor = CharacterColor.YELLOW;
	public static CharacterColor ghostColor = CharacterColor.PINK;

	public static int remainPellets() { // check if any pellets left in a map
		return PelletHolder.getAllPellets().size();
	}

	public static ArrayList<Direction> validWay(double xPos, double yPos, Direction direction) {
		// check with map + x pos,y pos : what way its not the wall
		ArrayList<Direction> validDirection = new ArrayList<Direction>();

		if ((((xPos - 12) / 24) % 1 == 0) && getMapStateFromXYPosition(xPos, yPos - 12.05).equals("G")) {
			validDirection.add(Direction.NORTH);
		}
		if ((((xPos - 12) / 24) % 1 == 0) && getMapStateFromXYPosition(xPos, yPos + 12.05).equals("G")) {
			validDirection.add(Direction.SOUTH);
		}
		if ((((yPos - 12) / 24) % 1 == 0) && getMapStateFromXYPosition(xPos - 12.05, yPos).equals("G")) {;
			validDirection.add(Direction.WEST);
		}
		if ((((yPos - 12) / 24) % 1 == 0) && getMapStateFromXYPosition(xPos + 12.05, yPos).equals("G")) {
			validDirection.add(Direction.EAST);
		}
		return validDirection;
	}

	public static String getMapStateFromXYPosition(double xPos, double yPos) {

		double xPosToArrayIdx = Math.max(0, (xPos - 12) / 24);
		double yPosToArrayIdx = Math.max(0, (yPos - 12) / 24);
		int xPosInInt = (int) Math.round(xPosToArrayIdx);
		int yPosInInt = (int) Math.round(yPosToArrayIdx);
		if (yPosInInt > 17) { // for warp spot
			if (xPosInInt == 19) {
				return "G";
			} else {
				return "W";
			}

		}
		return String.valueOf(Map.getMap().charAt(yPosInInt * 38 + xPosInInt));
	}

	public static String getMapState(int xPos, int yPos) {
		return String.valueOf(Map.getMap().charAt(yPos * 38 + xPos));
	}

	public static int directionToInt(Direction direction) {
		switch (direction) {
		case NORTH:
			return 0;
		case EAST:
			return 90;
		case SOUTH:
			return 180;
		case WEST:
			return 270;
		default:
			return 0;
		}
	}

	public static Direction KeyCodeToDirection(String characterName, KeyCode keyCode) {
		if (characterName.equals(GameConstant.GHOST_NAME)) {
			switch (keyCode) {
			case I:
				return Direction.NORTH;
			case L:
				return Direction.EAST;
			case K:
				return Direction.SOUTH;
			case J:
				return Direction.WEST;
			default:
				return null;
			}
		} else if (characterName.equals(GameConstant.PACMAN_NAME)) {
			switch (keyCode) {
			case W:
				return Direction.NORTH;
			case D:
				return Direction.EAST;
			case S:
				return Direction.SOUTH;
			case A:
				return Direction.WEST;
			default:
				return null;
			}
		}
		return null;
	}

	public static ArrayList<Integer> getLocationNearPacMan(PacMan pacMan) {
		int startedX = Math.max((int) (Math.round((pacMan.getXPos() - 12) / 24) - 2), 0);
		int endedX = Math.min((int) (Math.round((pacMan.getXPos() - 12) / 24) + 2), GameConstant.SCREEN_PLAY_WIDTH);
		int startedY = Math.max((int) (Math.round((pacMan.getYPos() - 12) / 24) - 2), 0);
		int endedY = Math.min((int) (Math.round((pacMan.getYPos() - 12) / 24) + 2), GameConstant.SCREEN_PLAY_HEIGHT);
		ArrayList<Integer> location = new ArrayList<>();
		location.add(startedX);
		location.add(endedX);
		location.add(startedY);
		location.add(endedY);
		return location;
	}

	public static String CharacterColorToString(CharacterColor color) {
		return (color + "").toLowerCase();
	}

	public static boolean timeToRandomNewPower(long currentSecondtime, long startSecondTime) {
		long diffTime = currentSecondtime - startSecondTime;
		if ((diffTime) % GameConstant.BUFF_SPAWN_DURATION == 0 && diffTime != 0 && !GameController.alreadyRandomPower) {
			GameController.alreadyRandomPower = true;
			return true;
		}
		if ((diffTime) % GameConstant.BUFF_SPAWN_DURATION != 0) {
			GameController.alreadyRandomPower = false;
			return false;
		}
		return false;

	}

	public static void spawnNewPower() {
		ArrayList<Integer> randomPosition = randomPosition();
		int xRandomPos = randomPosition.get(0);
		int yRandomPos = randomPosition.get(1);
		long startRandomSecondTime = System.nanoTime() / 1000000000;
		SpecialPower randomPower = getPower(xRandomPos, yRandomPos, startRandomSecondTime);
		SpecialPowerHolder.getAllSpecialPowers().add(randomPower);
	}

	public static ArrayList<Integer> randomPosition() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 276 + 1);
		ArrayList<Integer> randomPosition = new ArrayList<>();
		randomPosition.add(Map.groundState[randomNum][0] * 24 + 12);
		randomPosition.add(Map.groundState[randomNum][1] * 24 + 12);
		return randomPosition;
	}

	public static SpecialPower getPower(int x, int y, long startRandomTime) {
		switch (counter % 4) {
		case 0:
			RevengePower revengePower = new RevengePower(x, y, startRandomTime);
			counter++;
			return revengePower;
		case 1:
			ShieldPower shieldPower = new ShieldPower(x, y, startRandomTime);
			counter++;
			return shieldPower;
		case 2:
			ShieldPower shieldPower1 = new ShieldPower(x, y, startRandomTime);
			counter++;
			return shieldPower1;
		case 3:
			StarvePower starvePower = new StarvePower(x, y, startRandomTime);
			counter++;
			return starvePower;
		}
		return null;
	}

	public static boolean IsGameEnd() {
		if (GameController.pacMan.getLife() <= 0) {
			return true;
		}
		if (remainPellets() <= 0) {
			return true;
		}
		return false;
	}

	public static boolean pacManWin() {
		return PelletHolder.getAllPellets().size() <= 0;
	}

	public static boolean GhostWin() {
		return GameController.pacMan.getLife() <= 0;
	}

	public static void restartGame() {
		GameCanvas.gameLoop.stop();
		RenderableHolder.getInstance().getEntities().clear();
		InputUtility.setFirstPlayerKeyNull();
		InputUtility.setSecondPlayerKeyNull();

	}

	public static boolean closeToSpawn(int x, int y) {
		for (int[] close : Map.closeToSpawnPosition) {
			if (x == close[0] && y == close[1]) {
				return true;
			}
		}
		return false;
	}

	public static CharacterColor getPacManColor() {
		return pacManColor;
	}

	public static void setPacManColor(CharacterColor pacManColor) {
		GameLogic.pacManColor = pacManColor;
	}

	public static CharacterColor getGhostColor() {
		return ghostColor;
	}

	public static void setGhostColor(CharacterColor ghostColor) {
		GameLogic.ghostColor = ghostColor;
	}

}
