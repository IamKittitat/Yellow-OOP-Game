package sharedObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.ImageIcon;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;

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
	public static Image MainMenuGIF;
	public static Image heartPNG;
	public static Image pauseButtonPNG;
	public static Image playButtonPNG;
	public static Image menuButtonPNG;

	public static Image wallPNG;
	public static Image spawnPNG;

	public static Font gameHeaderFont;
	public static Font gameSubHeaderFont;

	public static AudioClip ThemeSong_music;
	public static AudioClip ChasingGhost_music;
	public static AudioClip ClickedSound_music;
	public static AudioClip CollectPower_music;
	public static AudioClip EatPellet_music;
	public static AudioClip GameEnd_music;
	public static AudioClip PacManDie_music;
	public static AudioClip PacManEatGhost_music;
	public static AudioClip Playing_music;
	
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
		String img = "image/";
		String audio = "audio/";
		String font = "font/";

		ghostPNG1 = new Image(ClassLoader.getSystemResource(img + "ghost-1.png").toString());
		ghostPNG2 = new Image(ClassLoader.getSystemResource(img + "ghost-2.png").toString());
		ghostPNG3 = new Image(ClassLoader.getSystemResource(img + "ghost-3.png").toString());
		ghostPNG4 = new Image(ClassLoader.getSystemResource(img + "ghost-4.png").toString());
		pacManPNG1 = new Image(ClassLoader.getSystemResource(img + "pacman-1.png").toString());
		pacManPNG2 = new Image(ClassLoader.getSystemResource(img + "pacman-2.png").toString());
		pacManPNG3 = new Image(ClassLoader.getSystemResource(img + "pacman-3.png").toString());
		pacManPNG4 = new Image(ClassLoader.getSystemResource(img + "pacman-4.png").toString());
		MainMenuGIF = new Image(ClassLoader.getSystemResource(img + "MainMenu.gif").toString(), 400, 400, false, false);
		heartPNG = new Image(ClassLoader.getSystemResource(img + "heart.png").toString(), 30, 30, false, false);

		pauseButtonPNG = new Image(ClassLoader.getSystemResource(img + "pause-button.png").toString(), 50, 50, false,
				false);
		playButtonPNG = new Image(ClassLoader.getSystemResource(img + "play-button.png").toString(), 50, 50, false,
				false);
		menuButtonPNG = new Image(ClassLoader.getSystemResource(img + "menu-button.png").toString(), 50, 50, false,
				false);

		wallPNG = new Image(ClassLoader.getSystemResource(img + "wall.png").toString(), 24, 24, false, false);
		spawnPNG = new Image(ClassLoader.getSystemResource(img + "spawn.png").toString(), 24, 24, false, false);

		gameHeaderFont = Font.loadFont(ClassLoader.getSystemResource(font + "slkscrb.ttf").toString(), 45);
		gameSubHeaderFont = Font.loadFont(ClassLoader.getSystemResource(font + "slkscr.ttf").toString(), 45);

		ThemeSong_music = new AudioClip(ClassLoader.getSystemResource(audio + "ThemeSong.mp3").toString());
		ChasingGhost_music = new AudioClip(ClassLoader.getSystemResource(audio + "ChasingGhost.mp3").toString());
		ClickedSound_music = new AudioClip(ClassLoader.getSystemResource(audio + "ClickedSound.mp3").toString());
		CollectPower_music = new AudioClip(ClassLoader.getSystemResource(audio + "CollectPower.mp3").toString());
		EatPellet_music = new AudioClip(ClassLoader.getSystemResource(audio + "EatPellet.mp3").toString());
		GameEnd_music = new AudioClip(ClassLoader.getSystemResource(audio + "GameEnd.mp3").toString());
		PacManDie_music = new AudioClip(ClassLoader.getSystemResource(audio + "PacManDie.mp3").toString());
		PacManEatGhost_music = new AudioClip(ClassLoader.getSystemResource(audio + "PacManEatGhost.mp3").toString());
		Playing_music = new AudioClip(ClassLoader.getSystemResource(audio + "Playing.mp3").toString());
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
