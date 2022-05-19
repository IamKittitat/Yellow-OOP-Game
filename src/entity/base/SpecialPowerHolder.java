package entity.base;

import java.util.ArrayList;

import constant.GameConstant;
import entity.character.Ghost;
import entity.character.PacMan;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import logic.GameController;

public class SpecialPowerHolder extends Entity {
	private static ArrayList<SpecialPower> allSpecialPowers;

	public SpecialPowerHolder() {
		super();
		SpecialPowerHolder.allSpecialPowers = new ArrayList<SpecialPower>();
	}

	@Override
	public void draw(GraphicsContext gc) {
		for (SpecialPower s : SpecialPowerHolder.getAllSpecialPowers()) {
			if (s.isVisible() && !s.isRemoved()) {
				s.draw(gc);
			}
		}
	}

	public void update() {
		long currentSecondtime = System.nanoTime() / 1000000000;

		for (SpecialPower specialPower : SpecialPowerHolder.getAllSpecialPowers()) {
			if (!specialPower.isRemoved() && GameController.pacMan.isCollide(specialPower)
					&& specialPower.getEatenBy().contains(GameController.pacMan.getName())) {
				GameController.pacMan.collideWith(specialPower);
			} else if (!specialPower.isRemoved() && GameController.ghost.isCollide(specialPower)
					&& specialPower.getEatenBy().contains(GameController.ghost.getName())) {
				GameController.ghost.collideWith(specialPower);
			}

			// If Special Power not collected in time > remove it from the map and
			// specialPowerHolder
			if ((currentSecondtime - specialPower.getStartRandomSecondTime()) > GameConstant.BUFF_DISSAPEAR_TIME) {
				if (specialPower.getCollector() == null) { // no one collected
					// Prevent concurrent exception
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							SpecialPowerHolder.getAllSpecialPowers().remove(specialPower);
							specialPower.setRemoved(true);
						}
					});
				}
			}

			// Check Duration of special Power;
			if (specialPower.getStartPowerSecondTime() != 0
					&& (currentSecondtime - specialPower.getStartPowerSecondTime()) > specialPower.getDuration()
					&& specialPower.getCollector() != null) {
				ArrayList<Character> otherCharacter = new ArrayList<Character>();
				if (specialPower.getCollector() instanceof PacMan) {
					otherCharacter.add(GameController.ghost);
					otherCharacter.add(GameController.ghostBot1);
				} else if (specialPower.getCollector() instanceof Ghost) {
					otherCharacter.add(GameController.pacMan);
				}
				specialPower.clearPower(otherCharacter);
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						SpecialPowerHolder.getAllSpecialPowers().remove(specialPower);
						specialPower.setRemoved(true);
					}
				});
			}
		}
	}

	public static ArrayList<SpecialPower> getAllSpecialPowers() {
		return allSpecialPowers;
	}

}
