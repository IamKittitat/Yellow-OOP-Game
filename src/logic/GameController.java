package logic;

import java.util.ArrayList;
import java.util.List;

import constant.CharacterColor;
import entity.base.Entity;
import entity.character.Ghost;
import entity.character.PacMan;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class GameController {
	private List<Entity> gameObjectContainer;
	
	private PacMan pacMan;
	private Ghost ghost;

	public GameController() {
		super();
		this.gameObjectContainer = new ArrayList<Entity>();
		pacMan = new PacMan(CharacterColor.YELLOW);
		ghost = new Ghost(CharacterColor.YELLOW);
		addNewObject(pacMan);
		addNewObject(ghost);
		
		// TODO Auto-generated constructor stub
	}
	
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate(){
		pacMan.update();
		ghost.update();
	}
}
