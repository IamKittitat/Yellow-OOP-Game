package entity.item;

import java.util.ArrayList;

import constant.GameConstant;
import entity.base.Character;
import entity.base.SpecialPower;
import entity.character.Ghost;
import entity.character.PacMan;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SpeedPower extends SpecialPower{
	
	public SpeedPower(int x,int y) {
		super();
		this.name = GameConstant.SPEED_BUFF_NAME;
		this.detail = GameConstant.SPEED_BUFF_DETAIL;
		this.xPos = x;
		this.yPos = y;
		setEaten(false);
		super.getEatenBy().add("PacMan");
		super.getEatenBy().add("Ghost");
		this.duration = GameConstant.SPEED_BUFF_DURATION;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// gc.drawImage(RenderableHolder.speedPower, this.xPos, this.yPos);
		gc.setFill(Color.CYAN);
		gc.fillRoundRect(xPos, yPos, 5, 5, 5, 5);
	}

	@Override
	public void gainPower(Character collector,ArrayList<Character> other) {
		System.out.println("Gain Speed Power");
		collector.setSpeed(GameConstant.BUFF_SPEED);
	}

	@Override
	public void clearPower(Character collector,ArrayList<Character> other) {
		if (collector instanceof PacMan) {
			collector.setSpeed(GameConstant.PACMAN_SPEED);
		} else if (collector instanceof Ghost) {
			collector.setSpeed(GameConstant.GHOST_SPEED);
		}
	}
}
