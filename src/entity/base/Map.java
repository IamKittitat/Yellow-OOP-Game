package entity.base;

import constant.GameConstant;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import logic.GameLogic;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class Map implements IRenderable {

	private static String map = "WWWWWWWWWWWWWWWWWWWGWWWWWWWWWWWWWWWWWWWGGGGGGGGGGGGGGGWWWGWWWGGGGWWWWWWWWWWWWGWWWGWWWGWWGWWGWWWGWWWGWWGGGGGGGGGGGWWGWWWGWWWGWWGWWGWWWGWWWGWWWWWWWGWWWWGWWGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGWWWWGWWGWWWGWWWGWWWWWWGWWGWWGWWWWWWWWGWWWWGWWGWWWGWWWGWWWWWWGGGGGGGWWWWWWWWGWWWWGWWGGGGGGGGGWWWWWWGXXGXXGWWWGGGGGGGGGGGWWGWGWWWGWGWWGGGGGXGGGXGWWWGWWWWGWWGWWWWGWGWWWGWGWWGWWWGXGGGXGWWWGWWWWGWWGWWWWGGGGGGGGGGGGWWWGXXXXXGGGGGGGGGGGGGGGWWGWWWWWWWGWWWWWWGGGGGGGWWWWWWWWGWWGWGWWGWWWWWWWGWWWWWWGWWGWWGWWWWWWWWGWWGWGWWGGGGGGGGGGGGGGGGGGGGGGGGGWWWWWGWWGWGWWGWWWWGWWGWWGWWGWWWGWWWGWGGGGGGGGGGGGWWGWWWWGWWGWWGWWGWWWGWWWGWWWWGWWGWWGWGWWGGGGGGGGGGGGGGGWWWGWWWGGGGGGWWGGGGGGWWWWWWWWWWWWWWWWWWWWGWWWWWWWWWWWWWWWWWW";
	public static int[][] groundState = { { 1, 1 }, { 2, 1 }, { 3, 1 }, { 4, 1 }, { 5, 1 }, { 6, 1 }, { 7, 1 },
			{ 8, 1 }, { 9, 1 }, { 10, 1 }, { 11, 1 }, { 12, 1 }, { 13, 1 }, { 14, 1 }, { 15, 1 }, { 19, 1 }, { 23, 1 },
			{ 24, 1 }, { 25, 1 }, { 26, 1 }, { 1, 2 }, { 5, 2 }, { 9, 2 }, { 12, 2 }, { 15, 2 }, { 19, 2 }, { 23, 2 },
			{ 26, 2 }, { 27, 2 }, { 28, 2 }, { 29, 2 }, { 30, 2 }, { 31, 2 }, { 32, 2 }, { 33, 2 }, { 34, 2 },
			{ 35, 2 }, { 36, 2 }, { 1, 3 }, { 5, 3 }, { 9, 3 }, { 12, 3 }, { 15, 3 }, { 19, 3 }, { 23, 3 }, { 31, 3 },
			{ 36, 3 }, { 1, 4 }, { 2, 4 }, { 3, 4 }, { 4, 4 }, { 5, 4 }, { 6, 4 }, { 7, 4 }, { 8, 4 }, { 9, 4 },
			{ 10, 4 }, { 11, 4 }, { 12, 4 }, { 13, 4 }, { 14, 4 }, { 15, 4 }, { 16, 4 }, { 17, 4 }, { 18, 4 },
			{ 19, 4 }, { 20, 4 }, { 21, 4 }, { 22, 4 }, { 23, 4 }, { 24, 4 }, { 25, 4 }, { 26, 4 }, { 27, 4 },
			{ 28, 4 }, { 29, 4 }, { 30, 4 }, { 31, 4 }, { 36, 4 }, { 1, 5 }, { 5, 5 }, { 9, 5 }, { 16, 5 }, { 19, 5 },
			{ 22, 5 }, { 31, 5 }, { 36, 5 }, { 1, 6 }, { 5, 6 }, { 9, 6 }, { 16, 6 }, { 17, 6 }, { 18, 6 }, { 19, 6 },
			{ 20, 6 }, { 21, 6 }, { 22, 6 }, { 31, 6 }, { 36, 6 }, { 1, 7 }, { 2, 7 }, { 3, 7 }, { 4, 7 }, { 5, 7 },
			{ 6, 7 }, { 7, 7 }, { 8, 7 }, { 9, 7 }, { 16, 7 }, { 19, 7 }, { 22, 7 }, { 26, 7 }, { 27, 7 }, { 28, 7 },
			{ 29, 7 }, { 30, 7 }, { 31, 7 }, { 32, 7 }, { 33, 7 }, { 34, 7 }, { 35, 7 }, { 36, 7 }, { 1, 8 }, { 3, 8 },
			{ 7, 8 }, { 9, 8 }, { 12, 8 }, { 13, 8 }, { 14, 8 }, { 15, 8 }, { 16, 8 }, { 18, 8 }, { 19, 8 }, { 20, 8 },
			{ 22, 8 }, { 26, 8 }, { 31, 8 }, { 34, 8 }, { 1, 9 }, { 3, 9 }, { 7, 9 }, { 9, 9 }, { 12, 9 }, { 16, 9 },
			{ 18, 9 }, { 19, 9 }, { 20, 9 }, { 22, 9 }, { 26, 9 }, { 31, 9 }, { 34, 9 }, { 1, 10 }, { 2, 10 },
			{ 3, 10 }, { 4, 10 }, { 5, 10 }, { 6, 10 }, { 7, 10 }, { 8, 10 }, { 9, 10 }, { 10, 10 }, { 11, 10 },
			{ 12, 10 }, { 16, 10 }, { 22, 10 }, { 23, 10 }, { 24, 10 }, { 25, 10 }, { 26, 10 }, { 27, 10 }, { 28, 10 },
			{ 29, 10 }, { 30, 10 }, { 31, 10 }, { 32, 10 }, { 33, 10 }, { 34, 10 }, { 35, 10 }, { 36, 10 }, { 1, 11 },
			{ 9, 11 }, { 16, 11 }, { 17, 11 }, { 18, 11 }, { 19, 11 }, { 20, 11 }, { 21, 11 }, { 22, 11 }, { 31, 11 },
			{ 36, 11 }, { 1, 12 }, { 9, 12 }, { 16, 12 }, { 19, 12 }, { 22, 12 }, { 31, 12 }, { 36, 12 }, { 1, 13 },
			{ 2, 13 }, { 3, 13 }, { 4, 13 }, { 5, 13 }, { 6, 13 }, { 7, 13 }, { 8, 13 }, { 9, 13 }, { 10, 13 },
			{ 11, 13 }, { 12, 13 }, { 13, 13 }, { 14, 13 }, { 15, 13 }, { 16, 13 }, { 17, 13 }, { 18, 13 }, { 19, 13 },
			{ 20, 13 }, { 21, 13 }, { 22, 13 }, { 23, 13 }, { 24, 13 }, { 25, 13 }, { 31, 13 }, { 36, 13 }, { 1, 14 },
			{ 6, 14 }, { 9, 14 }, { 12, 14 }, { 15, 14 }, { 19, 14 }, { 23, 14 }, { 25, 14 }, { 26, 14 }, { 27, 14 },
			{ 28, 14 }, { 29, 14 }, { 30, 14 }, { 31, 14 }, { 36, 14 }, { 1, 15 }, { 6, 15 }, { 9, 15 }, { 12, 15 },
			{ 15, 15 }, { 19, 15 }, { 23, 15 }, { 28, 15 }, { 31, 15 }, { 36, 15 }, { 1, 16 }, { 2, 16 }, { 3, 16 },
			{ 4, 16 }, { 5, 16 }, { 6, 16 }, { 7, 16 }, { 8, 16 }, { 9, 16 }, { 10, 16 }, { 11, 16 }, { 12, 16 },
			{ 13, 16 }, { 14, 16 }, { 15, 16 }, { 19, 16 }, { 23, 16 }, { 24, 16 }, { 25, 16 }, { 26, 16 }, { 27, 16 },
			{ 28, 16 }, { 31, 16 }, { 32, 16 }, { 33, 16 }, { 34, 16 }, { 35, 16 }, { 36, 16 } };

	public static int[][] closeToSpawnPosition = { { 17, 6 }, { 18, 6 }, { 19, 6 }, { 20, 6 }, { 21, 6 }, { 19, 7 },
			{ 18, 8 }, { 19, 8 }, { 20, 8 }, { 18, 9 }, { 19, 9 }, { 20, 9 } };

	public String getTerrain(int x, int y) {
		if (x < 0 || x > GameConstant.SCREEN_PLAY_WIDTH || y < 0 || y > GameConstant.SCREEN_PLAY_HEIGHT)
			return "W";
		return GameLogic.getMapState(x, y);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		for (int y = 0; y <= GameConstant.SCREEN_PLAY_HEIGHT; y++) {
			for (int x = 0; x <= GameConstant.SCREEN_PLAY_WIDTH; x++) {
				// System.out.println(getTerrain(x,y));
				switch (getTerrain(x, y)) {
				case "W":
					gc.drawImage(RenderableHolder.wallPNG, x * GameConstant.BLOCK_SIZE, y * GameConstant.BLOCK_SIZE);
					break;
				case "G":
					gc.setFill(Color.BLACK);
					gc.fillRect(x * GameConstant.BLOCK_SIZE, y * GameConstant.BLOCK_SIZE, GameConstant.BLOCK_SIZE,
							GameConstant.BLOCK_SIZE);
					break;
				case "X":
					gc.setFill(Color.PINK);
					gc.drawImage(RenderableHolder.spawnPNG, x * GameConstant.BLOCK_SIZE, y * GameConstant.BLOCK_SIZE);
					break;
				default:
					gc.setFill(Color.BLACK);
					gc.fillRect(x * GameConstant.BLOCK_SIZE, y * GameConstant.BLOCK_SIZE, GameConstant.BLOCK_SIZE,
							GameConstant.BLOCK_SIZE);
				}
			}
		}
	}

	@Override
	public boolean isRemoved() {
		// TODO Auto-generated method stub
		return false;
	}

	public static String getMap() {
		return map;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

}
