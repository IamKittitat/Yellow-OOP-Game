package entity.base;

import java.util.ArrayList;

import constant.GameConstant;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.GameLogic;
import sharedObject.IRenderable;

public class PelletHolder extends Entity {
	private ArrayList<Pellet> allPellets;

	public PelletHolder() {
		super();
		allPellets = new ArrayList<Pellet>();
		for (int y = 0; y <= GameConstant.SCREEN_PLAY_HEIGHT; y++) {
			for (int x = 0; x <= GameConstant.SCREEN_PLAY_WIDTH; x++) {
				if (GameLogic.getMapState(x, y).equals("G") && !GameLogic.closeToSpawn(x, y)) {
					// *BlockSize + (Blocksize/2) to re-position it to the center of the block
					allPellets.add(new Pellet(x * GameConstant.BLOCK_SIZE + 12, y * GameConstant.BLOCK_SIZE + 12));
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
