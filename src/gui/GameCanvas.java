package gui;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.GameController;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class GameCanvas extends Canvas {
	private static GraphicsContext gc;
	public static AnimationTimer gameLoop;
	public static GameController controller;
	public static int counter;

	public GameCanvas() {
		super();
		this.setWidth(912);
		this.setHeight(430);

		GameCanvas.gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

		GameCanvas.controller = new GameController();
		GameCanvas.counter = 0;

		RenderableHolder.loadCharacter();
		this.loop();
	}

	public void paintComponent() {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

		counter++;
		if (counter > 20) {
			counter -= 20;
		}
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity.isVisible() && !entity.isRemoved()) {
				entity.draw(gc);
			}
		}
	}

	public void loop() {
		(GameCanvas.gameLoop = new AnimationTimer() {
			public void handle(final long currentNanotime) {
				long currentSecondTime = currentNanotime / 1000000000;
				controller.logicUpdate(currentSecondTime);
				paintComponent();
			}
		}).start();
	}

}
