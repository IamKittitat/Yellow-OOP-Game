package entity.base;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import logic.GameLogic;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class Map implements IRenderable {

	private static String map = "WWWWWWWWWWWWWWWWWWWOWWWWWWWWWWWWWWWWWWWGGGGGGGGGGGGGGGWWWGWWWGGGGWWWWWWWWWWWWGWWWGWWWGWWGWWGWWWGWWWGWWGGGGGGGGGGGWWGWWWGWWWGWWGWWGWWWGWWWGWWWWWWWGWWWWGWWGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGWWWWGWWGWWWGWWWGWWWWWWGWWGWWGWWWWWWWWGWWWWGWWGWWWGWWWGWWWWWWGGGGGGGWWWWWWWWGWWWWGWWGGGGGGGGGWWWWWWGXXGXXGWWWGGGGGGGGGGGWWGWGWWWGWGWWGGGGGXGGGXGWWWGWWWWGWWGWWWWGWGWWWGWGWWGWWWGXGGGXGWWWGWWWWGWWGWWWWGGGGGGGGGGGGWWWGXXXXXGGGGGGGGGGGGGGGWWGWWWWWWWGWWWWWWGGGGGGGWWWWWWWWGWWWWGWWGWWWWWWWGWWWWWWGWWGWWGWWWWWWWWGWWWWGWWGGGGGGGGGGGGGGGGGGGGGGGGGWWWWWGWWWWGWWGWWWWGWWGWWGWWGWWWGWWWGWGGGGGGGWWWWGWWGWWWWGWWGWWGWWGWWWGWWWGWWWWGWWGWWWWGWWGGGGGGGGGGGGGGGWWWGWWWGGGGGGWWGGGGGGWWWWWWWWWWWWWWWWWWWWOWWWWWWWWWWWWWWWWWW";

	public String getTerrain(int x, int y) {
		if (x < 0 || x >= 38 || y < 0 || y >= 18)
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
		for (int y = 0; y < 18; y++) {
			for (int x = 0; x < 38; x++) {
				//System.out.println(getTerrain(x,y));
				switch(getTerrain(x,y)) {
				case "W":
					gc.setFill(Color.ORANGE);
					gc.fillRect(x*24, y*24, 24, 24);
					break;
				case "G":
					gc.setFill(Color.BLACK);
					gc.fillRect(x*24, y*24, 24, 24);
					break;
				case "X":
					gc.setFill(Color.PINK);
					gc.fillRect(x*24, y*24, 24, 24);
					break;
				default:
					gc.setFill(Color.YELLOW);
					gc.fillRect(x*24, y*24, 24, 24);
				}
			}
		}
		
//		for (int x = 0; x <= gc.getCanvas().getWidth(); x++) {
//			for (int y = 0; y <= gc.getCanvas().getHeight(); y++) {
//				if(x == 300 || y == 200) {
//					gc.setFill(Color.RED);
//					gc.fillRect(x, y, 64, 64);
//				}
//			}
//		}
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
