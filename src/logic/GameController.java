package logic;

import java.util.ArrayList;
import java.util.List;

import constant.CharacterColor;
import entity.base.Entity;
import entity.base.Map;
import entity.base.PelletHolder;
import entity.character.Ghost;
import entity.character.GhostBot;
import entity.character.PacMan;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class GameController {
	private List<Entity> gameObjectContainer;

	public static PacMan pacMan;
	public static Ghost ghost;
	public static GhostBot ghostBot1;
	public static GhostBot ghostBot2;
	public static PelletHolder pelletHolder;

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

		addNewObject(pacMan);
		addNewObject(ghost);

		addNewObject(pelletHolder);
//		addNewObject(ghostBot1);
//		addNewObject(ghostBot2);

		// TODO Auto-generated constructor stub
	}

	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}

	public void logicUpdate() {
		pacMan.update();
		ghost.update();
		if (pacMan.isCollide(ghost)) {
			System.out.println("Check collide");
			pacMan.collideWith(ghost);
		}
//		ghostBot1.update();
//		ghostBot2.update();
	}
}
