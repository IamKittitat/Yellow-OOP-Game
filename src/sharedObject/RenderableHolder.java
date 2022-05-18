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
import logic.GameController;
import logic.GameLogic;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image pacManIcon;
	public static Image ghostPNG1;
	public static Image ghostPNG2;
	public static Image scaredGhostPNG1;
	public static Image scaredGhostPNG2;
	public static Image ghostBotPNG1;
	public static Image ghostBotPNG2;

	public static Image pacManPNG1;
	public static Image pacManPNG2;
	public static Image pacManPNG3;
	public static Image pacManPNG4;

	public static Image mainMenuGIF;
	public static Image yellowPacManGIF;
	public static Image bluePacManGIF;
	public static Image pinkPacManGIF;
	public static Image pinkGhostGIF;
	public static Image greenGhostGIF;
	public static Image purpleGhostGIF;

	public static Image heartPNG;
	public static Image pauseButtonPNG;
	public static Image playButtonPNG;
	public static Image menuButtonPNG;
	public static Image gameIconPNG;

	public static Image wallPNG;
	public static Image spawnPNG;

	public static Image shieldPNG;
	public static Image starvePNG;
	public static Image revengePNG;

	public static Image howToPlay1PNG;
	public static Image howToPlay2PNG;
	
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
		String gif = "gif/";
		String audio = "audio/";
		String font = "font/";

		scaredGhostPNG1 = new Image(ClassLoader.getSystemResource(img + "scaredGhost-1.png").toString());
		scaredGhostPNG2 = new Image(ClassLoader.getSystemResource(img + "scaredGhost-2.png").toString());
		ghostBotPNG1 = new Image(ClassLoader.getSystemResource(img + "GhostBot1.png").toString());
		ghostBotPNG2 = new Image(ClassLoader.getSystemResource(img + "GhostBot2.png").toString());

		heartPNG = new Image(ClassLoader.getSystemResource(img + "heart.png").toString(), 30, 30, false, false);

		pauseButtonPNG = new Image(ClassLoader.getSystemResource(img + "pause-button.png").toString(), 50, 50, false,
				false);
		playButtonPNG = new Image(ClassLoader.getSystemResource(img + "play-button.png").toString(), 50, 50, false,
				false);
		menuButtonPNG = new Image(ClassLoader.getSystemResource(img + "menu-button.png").toString(), 50, 50, false,
				false);
		gameIconPNG = new Image(ClassLoader.getSystemResource(img + "ghost-1.png").toString());

		mainMenuGIF = new Image(ClassLoader.getSystemResource(gif + "main-menu.gif").toString(), 400, 400, false,
				false);
		yellowPacManGIF = new Image(ClassLoader.getSystemResource(gif + "yellow-pacman.gif").toString(), 100, 100,
				false, false);
		bluePacManGIF = new Image(ClassLoader.getSystemResource(gif + "blue-pacman.gif").toString(), 100, 100, false,
				false);
		pinkPacManGIF = new Image(ClassLoader.getSystemResource(gif + "pink-pacman.gif").toString(), 100, 100, false,
				false);
		pinkGhostGIF = new Image(ClassLoader.getSystemResource(gif + "pink-ghost.gif").toString(), 100, 100, false,
				false);
		greenGhostGIF = new Image(ClassLoader.getSystemResource(gif + "green-ghost.gif").toString(), 100, 100, false,
				false);
		purpleGhostGIF = new Image(ClassLoader.getSystemResource(gif + "purple-ghost.gif").toString(), 100, 100, false,
				false);

		wallPNG = new Image(ClassLoader.getSystemResource(img + "wall.png").toString(), 24, 24, false, false);
		spawnPNG = new Image(ClassLoader.getSystemResource(img + "spawn.png").toString(), 24, 24, false, false);

		shieldPNG = new Image(ClassLoader.getSystemResource(img + "shield.png").toString(), 24, 24, false, false);
		starvePNG = new Image(ClassLoader.getSystemResource(img + "starve.png").toString(), 24, 24, false, false);
		revengePNG = new Image(ClassLoader.getSystemResource(img + "revenge.png").toString(), 24, 24, false, false);

		howToPlay1PNG = new Image(ClassLoader.getSystemResource(img + "howToPlay1.png").toString(), 24, 24, false, false);
		howToPlay2PNG = new Image(ClassLoader.getSystemResource(img + "howToPlay2.png").toString(), 24, 24, false, false);
		
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

	public static void loadCharacter() {
		String img = "image/";
		String ghostColor = GameLogic.CharacterColorToString(GameLogic.ghostColor) + "/";
		String pacManColor = GameLogic.CharacterColorToString(GameLogic.pacManColor) + "/";

		ghostPNG1 = new Image(ClassLoader.getSystemResource(img + "ghost/" + ghostColor + "ghost-1.png").toString());
		ghostPNG2 = new Image(ClassLoader.getSystemResource(img + "ghost/" + ghostColor + "ghost-2.png").toString());

		pacManPNG1 = new Image(
				ClassLoader.getSystemResource(img + "pacman/" + pacManColor + "pacman-1.png").toString());
		pacManPNG2 = new Image(
				ClassLoader.getSystemResource(img + "pacman/" + pacManColor + "pacman-2.png").toString());
		pacManPNG3 = new Image(
				ClassLoader.getSystemResource(img + "pacman/" + pacManColor + "pacman-3.png").toString());
		pacManPNG4 = new Image(
				ClassLoader.getSystemResource(img + "pacman/" + pacManColor + "pacman-4.png").toString());
	}

	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
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
