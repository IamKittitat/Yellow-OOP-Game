package entity.base;

import java.util.ArrayList;

import entity.item.RevengePower;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;

public class SpecialPowerHolder extends Entity implements IRenderable {
	private ArrayList<SpecialPower> allSpecialPowers;
	
	public SpecialPowerHolder() {
		super();
		// TODO Auto-generated constructor stub
		this.allSpecialPowers = new ArrayList<SpecialPower>();
	}

	@Override
	public void draw(GraphicsContext gc) {
		for(SpecialPower i : this.getAllSpecialPowers()) {
			if (i.isVisible() && !i.isRemoved()) {
				i.draw(gc);
			}
		}
	}

	public ArrayList<SpecialPower> getAllSpecialPowers() {
		return allSpecialPowers;
	}

}
