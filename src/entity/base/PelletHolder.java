package entity.base;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.GameLogic;
import sharedObject.IRenderable;

public class PelletHolder extends Entity implements IRenderable {
	private ArrayList<Pellet> allPellets;

	public PelletHolder() {
		super();
		allPellets = new ArrayList<Pellet>();
		for (int y = 0; y < 18; y++) {
			for (int x = 0; x < 38; x++) {
				// System.out.println(getTerrain(x,y));
				if (GameLogic.getMapState(x, y).equals("G")) {
					allPellets.add(new Pellet(x, y));
				}
			}
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		for (Pellet p : this.getAllPellets()) {
			p.draw(gc);
		}
	}

	@Override
	public boolean isRemoved() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	public ArrayList<Pellet> getAllPellets() {
		return allPellets;
	}

}
