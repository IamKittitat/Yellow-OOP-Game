package entity.base;

public abstract class SpecialPower extends Item {
	protected int duration;

	public int getDuration() {
		return duration;
	}

	public abstract void gainPower(Entity entity);

	public abstract void clearPower(Entity entity);

}
