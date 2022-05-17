package sharedObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.ImageIcon;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image pacManIcon;
	public static Image ghostPNG1;
	public static Image ghostPNG2;
	public static Image ghostPNG3;
	public static Image ghostPNG4;
	public static Image pacManPNG1;
	public static Image pacManPNG2;
	public static Image pacManPNG3;
	public static Image pacManPNG4;
	public static Image heartPNG;
	public static Image pauseButtonPNG;
	public static Image playButtonPNG;
//	public static Image mapSprite;
//	public static Image mineSprite;
//	public static AudioClip  explosionSound;

	static {
		loadResource();
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
		ghostPNG1 = new Image(ClassLoader.getSystemResource("ghost-1.png").toString());
		ghostPNG2 = new Image(ClassLoader.getSystemResource("ghost-2.png").toString());
		ghostPNG3 = new Image(ClassLoader.getSystemResource("ghost-3.png").toString());
		ghostPNG4 = new Image(ClassLoader.getSystemResource("ghost-4.png").toString());
		pacManPNG1 = new Image(ClassLoader.getSystemResource("pacman-1.png").toString());
		pacManPNG2 = new Image(ClassLoader.getSystemResource("pacman-2.png").toString());
		pacManPNG3 = new Image(ClassLoader.getSystemResource("pacman-3.png").toString());
		pacManPNG4 = new Image(ClassLoader.getSystemResource("pacman-4.png").toString());
		heartPNG = new Image(ClassLoader.getSystemResource("heart.png").toString(),30, 30, false, false);
		pauseButtonPNG = new Image(ClassLoader.getSystemResource("pause-button.png").toString(),50, 50, false, false);
		playButtonPNG = new Image(ClassLoader.getSystemResource("play-button.png").toString(),50, 50, false, false);
	}

	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
//		for(IRenderable x: entities){
//			if(x instanceof Tank) System.out.println("tank");
//			if(x instanceof Mine) System.out.println("mine");
//			if(x instanceof Field) System.out.println("field");
//			
//		}
	}

	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isRemoved())
				entities.remove(i);
		}
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
}
