package logic;

import java.util.ArrayList;
import java.util.List;

import constant.CharacterColor;
import entity.base.Entity;
import entity.base.Map;
import entity.base.Pellet;
import entity.base.PelletHolder;
import entity.base.SpecialPower;
import entity.base.SpecialPowerHolder;
import entity.character.Ghost;
import entity.character.GhostBot;
import entity.character.PacMan;
import gui.GameCanvas;
import gui.GameControlPane;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class GameController {
	private List<Entity> gameObjectContainer;

	public static PacMan pacMan;
	public static Ghost ghost;
	public static GhostBot ghostBot1;
	public static GhostBot ghostBot2;
	public static PelletHolder pelletHolder;
	public static SpecialPowerHolder specialPowerHolder;
	public static GameControlPane gameControlPane;
	public static boolean alreadyRandomPower = false;
	final long startNanoTime = System.nanoTime();
	final long startSecondTime = startNanoTime / 1000000000;

	public GameController() {
		super();
		this.gameObjectContainer = new ArrayList<Entity>();

		Map map = new Map();
		RenderableHolder.getInstance().add(map);

		pacMan = new PacMan(CharacterColor.YELLOW);
		ghost = new Ghost(CharacterColor.YELLOW);
		ghostBot1 = new GhostBot();
		ghostBot2 = new GhostBot();
		pelletHolder = new PelletHolder();
		specialPowerHolder = new SpecialPowerHolder();
		gameControlPane = new GameControlPane();

		addNewObject(pacMan);
		addNewObject(ghost);

		addNewObject(pelletHolder);
		addNewObject(specialPowerHolder);
//		addNewObject(ghostBot1);
//		addNewObject(ghostBot2);

		// TODO Auto-generated constructor stub
	}

	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}

	public void logicUpdate(long currentSecondtime) {
		pacMan.update();
		ghost.update();
		gameControlPane.updateLives();
		gameControlPane.updateScore();
//		ghostBot1.update();
//		ghostBot2.update();
		if (GameLogic.timeToRandomNewPower(currentSecondtime,startSecondTime)) {
			GameLogic.spawnNewPower();
		}

		if (pacMan.isCollide(ghost)) {
//			System.out.println("collide");
			pacMan.collideWith(ghost);
		}
		for(Pellet pellet : pelletHolder.getAllPellets()) {
//			System.out.println(pellet.getXPos()+", "+pellet.getYPos());
			if(!pellet.isRemoved() && pacMan.isCollide(pellet)) {
//				System.out.println("pellets");
				pacMan.collideWith(pellet);				
			}
		}
		for(SpecialPower specialPower : SpecialPowerHolder.getAllSpecialPowers()) {
//			System.out.println(pellet.getXPos()+", "+pellet.getYPos());
			if(!specialPower.isRemoved() && pacMan.isCollide(specialPower) && specialPower.getEatenBy().contains(pacMan.getName())) {
//				System.out.println("pellets");
				pacMan.collideWith(specialPower);				
			} else if(!specialPower.isRemoved() && ghost.isCollide(specialPower) && specialPower.getEatenBy().contains(ghost.getName()))  {
//				System.out.println("pellets");
				ghost.collideWith(specialPower);				
			}
		}

//		System.out.println(pacMan.getXPos()+", "+pacMan.getYPos());
//		ArrayList<Integer> LocationNearPacMan = GameLogic.getLocationNearPacMan(pacMan);
//		System.out.println(LocationNearPacMan.toString());
//		for(int x=LocationNearPacMan.get(0);x<=LocationNearPacMan.get(1);x++) {
//			for(int y=LocationNearPacMan.get(2);y<=LocationNearPacMan.get(3);y++) {
//				pelletHolder.getAllPellets()
//			}
//		}

	}
}
