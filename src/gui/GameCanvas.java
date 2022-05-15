package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameCanvas extends Canvas {
	private static GraphicsContext gc;
	
	public GameCanvas() {
		super(500,400);
		// TODO Auto-generated constructor stub
		GameCanvas.gc = this.getGraphicsContext2D();
		gc.setFill(Color.BEIGE);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		this.setWidth(900);
		this.setHeight(450);
	}

}
