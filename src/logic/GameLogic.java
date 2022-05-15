package logic;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import constant.Direction;
import constant.GameConstant;
import entity.base.SpecialPower;
import entity.character.PacMan;
import entity.item.RevengePower;
import entity.item.ShieldPower;
import entity.item.SpeedPower;
import entity.item.StarvePower;

public class GameLogic {

	public static boolean pelletsRemain(PacMan pacMan) { //check if any pellets left in a map
		return pacMan.getScore() < GameConstant.TOTAL_PELLET;
	}

	public static ArrayList<Direction> validWay(){
		// check with map + x pos,y pos : what way its not the wall
		return null;
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
	
	public static void spawnNewPower() {
		
	}
	
	public static SpecialPower randomPower() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 7 + 1);
		switch(randomNum) {
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
	
	public static ArrayList<Integer> randomPosition(){
		// random from arraylist of map that is ground state
		return null;
	}
	
	
//	> ใครชนะ
//	> endgame
//	> เลือกตัวละคร
}
