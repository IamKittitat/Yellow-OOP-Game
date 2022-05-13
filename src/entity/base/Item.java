package entity.base;

import java.util.ArrayList;

public abstract class Item extends Entity {
	private boolean isEaten;
	private ArrayList<String> eatenBy;

	public Item() {
		super();
		eatenBy = new ArrayList<>();
	}

	public void eaten(Entity e) {
		setEaten(true);
	}

	public boolean isEaten() {
		return isEaten;
	}

	public void setEaten(boolean isEaten) {
		this.isEaten = isEaten;
	}

	public ArrayList<String> getEatenBy() {
		return eatenBy;
	}

}
