package entity.item;

import java.util.ArrayList;

import constant.GameConstant;
import entity.base.Character;
import entity.base.SpecialPower;
import entity.character.PacMan;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class StarvePower extends SpecialPower {

	public StarvePower(int x, int y, long startRandomSecondTime) {
		super(startRandomSecondTime);
		this.name = GameConstant.STARVE_BUFF_NAME;
		this.xPos = x;
		this.yPos = y;
		setEaten(false);
		super.getEatenBy().add("Ghost");
		this.duration = GameConstant.STARVE_BUFF_DURATION;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(RenderableHolder.starvePNG, xPos - this.radius, yPos - this.radius, this.radius * 2,
				this.radius * 2);
	}

	@Override
	public void gainPower(Character collector, ArrayList<Character> other) {
		System.out.println("Gain Starve Power");
		setCollector(collector);
		collector.setPower(this);
		setStartPowerSecondTime(System.nanoTime() / 1000000000);
//		System.out.println(this.getStartPowerSecondTime());
		PacMan otherPacMan = (PacMan) other.get(0);
		otherPacMan.setCanEatPellet(false);
		System.out.println(otherPacMan.CanEatPellet());
	}

	@Override
	public void clearPower(ArrayList<Character> other) {
		PacMan otherPacMan = (PacMan) other.get(0);
		collector.setPower(null);
		otherPacMan.setCanEatPellet(true);
	}
}
