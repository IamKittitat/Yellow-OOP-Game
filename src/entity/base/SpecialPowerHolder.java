package entity.base;

import java.util.ArrayList;

import entity.item.RevengePower;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import sharedObject.IRenderable;

public class SpecialPowerHolder extends Entity implements IRenderable {
	private static ArrayList<SpecialPower> allSpecialPowers;

	public SpecialPowerHolder() {
		super();
		// TODO Auto-generated constructor stub
		this.allSpecialPowers = new ArrayList<SpecialPower>();
	}

	@Override
	public void draw(GraphicsContext gc) {
		for (SpecialPower s : this.getAllSpecialPowers()) {
			if (s.isVisible() && !s.isRemoved()) {
				s.draw(gc);
			}
		}
	}

//	public void update() {
//		this.getAllSpecialPowers().add(GameLogic.randomPower());
//	}

	public static ArrayList<SpecialPower> getAllSpecialPowers() {
		return allSpecialPowers;
	}

}
