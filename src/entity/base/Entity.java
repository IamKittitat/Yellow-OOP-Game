package entity.base;

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable{
	private String name;
	private String detail;
	private double xPos,yPos;
	private int z;
	private boolean visible,removed;
	
	public Entity(String name,String detail,double x,double y){
		setName(name);
		setDetail(detail);
		setX( );
		visible = true;
		removed = false;
	}
	
	@Override
	public boolean isRemoved(){
		return removed;
	}
	
	@Override
	public boolean isVisible(){
		return visible;
	}
	
	@Override
	public int getZ(){
		return z;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
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
