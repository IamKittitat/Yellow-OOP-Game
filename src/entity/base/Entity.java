package entity.base;

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable {
	protected String name;
	protected String detail;
	protected double xPos, yPos;
	protected double radius;
	private int z;
	private boolean visible, removed;

	public Entity() {
		visible = true;
		removed = false;
	}
	
	protected boolean isCollide(Entity other){
		return Math.hypot(this.xPos-other.xPos, this.yPos-other.yPos) <= this.radius+other.radius;
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
	
	public void setZ(int z) {
		this.z = z;
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

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}
}
