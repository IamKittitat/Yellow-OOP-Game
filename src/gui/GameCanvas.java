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
	private AnimationTimer gameLoop;
	private GameController controller;
	public static int counter;

	public GameCanvas() {
		super(500, 400);
		// TODO Auto-generated constructor stub
		GameCanvas.gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		this.setWidth(900);
		this.setHeight(450);
		this.setVisible(true);

		GameCanvas.counter = 0;

		controller = new GameController();
		this.loop();
	}

	public void paintComponent() {
		gc.setFill(Color.BLUE);
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
		(this.gameLoop = new AnimationTimer() {
			public void handle(final long now) {
				controller.logicUpdate();
				paintComponent();
			}
		}).start();
	}

}
