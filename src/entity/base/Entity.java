package entity.base;

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable {
	protected String name;
	protected String detail;
	protected double xPos, yPos;
	private int z;
	private boolean visible, removed;

	public Entity() {
		visible = true;
		removed = false;
	}

	@Override
	public boolean isRemoved() {
		return removed;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public int getZ() {
		return z;
	}

	public String getName() {
		return name;
	}

	public String getDetail() {
		return detail;
	}

	public double getXPos() {
		return xPos;
	}

	public void setXPos(double x) {
		this.xPos = x;
	}

	public double getYPos() {
		return yPos;
	}

	public void setYPos(double y) {
		this.yPos = y;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}
}
