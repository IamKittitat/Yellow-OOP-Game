package entity.base;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class Map implements IRenderable {

	private static int[][] map = { { -1, 0, 0, 0, 0, 0, 0, 0, -1, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

			{ 0, 0, 0, 0, 0, 0, -2, 0, 0, 0 }, { 0, -2, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, -1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	public int getTerrain(int x, int y) {
		if (x < 0 || x >= map[0].length || y < 0 || y >= map.length)
			return -3;
		return map[y][x];
	}

	private int getTileIndex(int x, int y) {
		int terrain = getTerrain(x, y);
		if (terrain <= 0 && terrain >= -2)
			return -terrain;
		else
			return 0;
	}
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		for (int x = 0; x <= gc.getCanvas().getWidth(); x++) {
			for (int y = 0; y <= gc.getCanvas().getHeight(); y++) {
				if(x == 300 || y == 200) {
					gc.setFill(Color.RED);
					gc.fillRect(x, y, 64, 64);
				}
			}
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

}
