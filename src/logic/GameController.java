package logic;

import java.util.ArrayList;
import java.util.List;

import constant.CharacterColor;
import constant.GameConstant;
import entity.base.Character;
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
import javafx.application.Platform;
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

		pacMan = new PacMan(GameLogic.pacManColor);
		ghost = new Ghost(GameLogic.ghostColor);
		ghostBot1 = new GhostBot();
		pelletHolder = new PelletHolder();
		specialPowerHolder = new SpecialPowerHolder();
		gameControlPane = new GameControlPane();

		addNewObject(pacMan);
		addNewObject(ghost);
		addNewObject(pelletHolder);
		addNewObject(specialPowerHolder);
		addNewObject(ghostBot1);

		// TODO Auto-generated constructor stub
	}

	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}

	public void logicUpdate(long currentSecondtime) {
		pacMan.update();
		ghost.update();
		ghostBot1.update();
		System.out.println("check");
		if (GameLogic.timeToRandomNewPower(currentSecondtime, startSecondTime)) {
			GameLogic.spawnNewPower();
		}

		if (pacMan.isCollide(ghost)) {
			pacMan.collideWith(ghost);
		}
		if (pacMan.isCollide(ghostBot1)) {
			pacMan.collideWith(ghostBot1);
		}
		gameControlPane.updateLives();
		gameControlPane.updateScore();

		pelletHolder.update();
		specialPowerHolder.update();

		if (GameLogic.IsGameEnd()) {
			GameCanvas.gameLoop.stop();
		}
	}
}
