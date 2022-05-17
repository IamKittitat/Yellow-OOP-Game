package gui;

import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import logic.GameController;
import logic.GameLogic;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class GameCanvas extends Canvas {
	private static GraphicsContext gc;
	public static AnimationTimer gameLoop;
	private GameController controller;
	public static int counter;

	public GameCanvas() {
		super();
		// TODO Auto-generated constructor stub
		GameCanvas.gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		this.setWidth(900);
		this.setHeight(430);
		this.setVisible(true);

		GameCanvas.counter = 0;

		controller = new GameController();
		this.loop();
	}

	public void paintComponent() {
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		counter++;
		if (counter > 20) {
			counter -= 20;
		}
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity.isVisible() && !entity.isRemoved()) {
				entity.draw(gc);
			}
//			entity.draw(gc);
		}
	}

	public void loop() {
		(GameCanvas.gameLoop = new AnimationTimer() {
			public void handle(final long currentNanotime) {
				long currentSecondTime = currentNanotime/1000000000;
				controller.logicUpdate(currentSecondTime);
				paintComponent();
			}
		}).start();
	}

}
