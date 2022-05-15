package logic;

import java.util.ArrayList;
import java.util.List;

import constant.CharacterColor;
import entity.base.Entity;
import entity.base.Map;
import entity.character.Ghost;
import entity.character.GhostBot;
import entity.character.PacMan;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class GameController {
	private List<Entity> gameObjectContainer;
	
	private PacMan pacMan;
	private Ghost ghost;
	private GhostBot ghostBot1;
	private GhostBot ghostBot2;

	public GameController() {
		super();
		this.gameObjectContainer = new ArrayList<Entity>();
		
		Map map = new Map();
		RenderableHolder.getInstance().add(map);
		
		pacMan = new PacMan(CharacterColor.YELLOW);
		ghost = new Ghost(CharacterColor.YELLOW);
		ghostBot1 = new GhostBot();
		ghostBot2 = new GhostBot();
		
		addNewObject(pacMan);
		addNewObject(ghost);
		addNewObject(ghostBot1);
		addNewObject(ghostBot2);
		
		// TODO Auto-generated constructor stub
	}
	
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate(){
		pacMan.update();
		ghost.update();
		ghostBot1.update();
		ghostBot2.update();
	}
}
