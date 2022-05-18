package entity.base;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.GameLogic;
import sharedObject.IRenderable;

public class PelletHolder extends Entity{
	private ArrayList<Pellet> allPellets;

	public PelletHolder() {
		super();
		allPellets = new ArrayList<Pellet>();
		for (int y = 0; y < 18; y++) {
			for (int x = 0; x < 38; x++) {
				// System.out.println(getTerrain(x,y));
				if (GameLogic.getMapState(x, y).equals("G") && !GameLogic.closeToSpawn(x,y)) {
					allPellets.add(new Pellet(x*24+12, y*24+12));
				}
			}
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		for (Pellet p : this.getAllPellets()) {
			if (p.isVisible() && !p.isRemoved()) {
				p.draw(gc);
			}
		}
	}

	public ArrayList<Pellet> getAllPellets() {
		return allPellets;
	}

}
