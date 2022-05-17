package entity.base;

import java.util.ArrayList;

public abstract class SpecialPower extends Item {
	protected int duration;
	protected long startRandomSecondTime;
	protected long startPowerSecondTime;
	protected Character collector;
	
	public SpecialPower(long startRandomSecondTime) {
		setStartRandomSecondTime(startRandomSecondTime);
	}

	public Character getCollector() {
		return collector;
	}

	public void setCollector(Character collector) {
		this.collector = collector;
	}

	
	public long getStartRandomSecondTime() {
		return startRandomSecondTime;
	}

	public void setStartRandomSecondTime(long startRandomSecondTime) {
		this.startRandomSecondTime = startRandomSecondTime;
	}

	public long getStartPowerSecondTime() {
		return startPowerSecondTime;
	}

	public void setStartPowerSecondTime(long startPowerSecondTime) {
		this.startPowerSecondTime = startPowerSecondTime;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}

	public abstract void gainPower(Character collector, ArrayList<Character> other);

	public abstract void clearPower(ArrayList<Character> other);
	
}
