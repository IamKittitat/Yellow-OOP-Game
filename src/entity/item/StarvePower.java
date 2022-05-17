package entity.item;

import java.util.ArrayList;

import constant.GameConstant;
import entity.base.Character;
import entity.base.SpecialPower;
import entity.character.PacMan;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class StarvePower extends SpecialPower{
	
	public StarvePower(int x,int y) {
		super();
		this.name = GameConstant.STARVE_BUFF_NAME;
		this.detail = GameConstant.STARVE_BUFF_DETAIL;
		this.xPos = x;
		this.yPos = y;
		setEaten(false);
		super.getEatenBy().add("Ghost");
		this.duration = GameConstant.STARVE_BUFF_DURATION;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.PURPLE);
		gc.fillRoundRect(xPos, yPos, 5, 5, 5, 5);
	}

	@Override
	public void gainPower(Character collector,ArrayList<Character> other) {
		System.out.println("Gain Starve Power");
		PacMan otherPacMan = (PacMan) other.get(0);
		otherPacMan.setCanEatPellet(false);
	}

	@Override
	public void clearPower(Character collector,ArrayList<Character> other) {
		PacMan otherPacMan = (PacMan) other.get(0);
		otherPacMan.setCanEatPellet(false);
	}
}
