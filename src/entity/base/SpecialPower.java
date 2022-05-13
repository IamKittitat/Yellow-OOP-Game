package entity.base;

public abstract class SpecialPower extends Item {
	protected int duration;

	public int getDuration() {
		return duration;
	}

	public abstract void gainPower(Entity collector,Entity other);

	public abstract void clearPower(Entity collector,Entity other);

}
