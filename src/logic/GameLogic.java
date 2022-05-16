package logic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import constant.CharacterColor;
import constant.Direction;
import constant.GameConstant;
import entity.base.ControlCharacter;
import entity.base.Map;
import entity.base.SpecialPower;
import entity.character.Ghost;
import entity.character.PacMan;
import entity.item.RevengePower;
import entity.item.ShieldPower;
import entity.item.SpeedPower;
import entity.item.StarvePower;
import javafx.scene.input.KeyCode;

public class GameLogic {

	public static boolean pelletsRemain(PacMan pacMan) { // check if any pellets left in a map
		return pacMan.getScore() < GameConstant.TOTAL_PELLET;
	}

	public static ArrayList<Direction> validWay(double xPos, double yPos, Direction direction) {
		// check with map + x pos,y pos : what way its not the wall
		ArrayList<Direction> validDirection = new ArrayList<Direction>();
//		System.out.println(xPos + "," + yPos);
//		if (direction == Direction.SOUTH) {
//			validDirection.add(Direction.NORTH);
//		} else if (direction == Direction.NORTH) {
//			validDirection.add(Direction.SOUTH);
//		} else if (direction == Direction.EAST) {
//			validDirection.add(Direction.WEST);
//		} else if (direction == Direction.WEST) {
//			validDirection.add(Direction.EAST);
//		}
		if ((((xPos - 12) / 24) % 1 == 0) && getMapStateFromXYPosition(xPos, yPos - 12.05).equals("G")) {
			validDirection.add(Direction.NORTH);
		}
		if ((((xPos - 12) / 24) % 1 == 0) && getMapStateFromXYPosition(xPos, yPos + 12.05).equals("G")) {
			validDirection.add(Direction.SOUTH);
		}
		if ((((yPos - 12) / 24) % 1 == 0) && getMapStateFromXYPosition(xPos - 12.05, yPos).equals("G")) {
			validDirection.add(Direction.WEST);
		}
		if ((((yPos - 12) / 24) % 1 == 0) && getMapStateFromXYPosition(xPos + 12.05, yPos).equals("G")) {
			validDirection.add(Direction.EAST);
		}
//		System.out.println(validDirection.toString());
		return validDirection;
	}

	public static String getMapStateFromXYPosition(double xPos, double yPos) {
		// System.out.println((xPos-12)/24 + " " + (yPos-12)/24);
//		int xPosToArrayIdx = (int) Math.max(0, (xPos-12)/24);
//		int yPosToArrayIdx = (int) Math.max(0, (yPos-12)/24);
//		double xPosToArrayIdx = Math.max(0, (xPos - 12) / 24);
//		double yPosToArrayIdx = Math.max(0, (yPos - 12) / 24);
//		System.out.println(xPosToArrayIdx + "," + yPosToArrayIdx);
//		int xPosInInt = (int) Math.ceil(xPosToArrayIdx);
//		int yPosInInt = (int) Math.ceil(yPosToArrayIdx);
//		return String.valueOf(Map.getMap().charAt(yPosInInt * 38 + xPosInInt));
//		System.out.println(xPosToArrayIdx+", "+yPosToArrayIdx);
//		return String.valueOf(Map.getMap().charAt(yPosToArrayIdx*38+xPosToArrayIdx));

		double xPosToArrayIdx = Math.max(0, (xPos - 12) / 24);
		double yPosToArrayIdx = Math.max(0, (yPos - 12) / 24);
//		System.out.println(xPosToArrayIdx + "," + yPosToArrayIdx);
		int xPosInInt = (int) Math.round(xPosToArrayIdx);
		int yPosInInt = (int) Math.round(yPosToArrayIdx);
//		int xPosInInt = (int) Math.round(xPosToArrayIdx);
//		int yPosInInt = (int) Math.round(yPosToArrayIdx);
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

	public static Color CharacterColorToColor(CharacterColor color) {
		switch (color) {
		case YELLOW:
			return Color.yellow;
		}
		return null;
	}

	public static void spawnNewPower() {
		// Get random place (x,y)
		// Get random buff(x,y)
		// New + add to renderable Holder
	}

	public static SpecialPower randomPower() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 7 + 1);
		switch (randomNum) {
		case 0:
			RevengePower revengePower = null;
			return revengePower;
		case 1:
			ShieldPower shieldPower = null;
			return shieldPower;
		case 2:
			SpeedPower speedPower = null;
			return speedPower;
		case 3:
			StarvePower starvePower = null;
			return starvePower;

		}
		return null;
	}

	public static ArrayList<Integer> randomPosition() {
		// random from arraylist of map that is ground state
		return null;
	}

	private static boolean ghostWin() {
		// pacman life <= 0;
		return false;

	}

	private static boolean pacManWin() {
		// all pellet collected
		return false;
	}

	public static boolean gameEnd() {
		// check pacman or ghost win
		// ???????
		return false;
	}
}
