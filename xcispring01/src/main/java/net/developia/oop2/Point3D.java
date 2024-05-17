package net.developia.oop2;

public class Point3D extends Point2D {
	int z;
	
	public Point3D() {
		this(1, 2, 3);
	}

	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
		System.out.println("Point3D(x, y, z) 수행");
	}
	
	@Override
	public String toString() {
		return super.toString() + ", z= " + z;
	}
}
