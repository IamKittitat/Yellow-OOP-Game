package entity.base;

import java.util.ArrayList;

public abstract class SpecialPower extends Item {
	protected int duration;

	public int getDuration() {
		return duration;
	}

	public abstract void gainPower(Character collector, ArrayList<Character> other);

	public abstract void clearPower(Character collector, ArrayList<Character> other);

}
