package net.developia.oop1;

public class Point2D {
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public void print() {
		System.out.println(this.getX());
		System.out.println(this.getY());
		
	}
}
