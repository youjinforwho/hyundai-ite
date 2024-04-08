package workshop06.shape;

public class Triangle extends Shape implements Resize{
	Triangle() {
		
	}
	Triangle(int width, int height, String colors) {
		super(width, height, colors);
	}
	@Override
	public double getArea() {
		return getWidth() * getHeight();
	}
	
	public void setResize(int size) {
		setHeight(getHeight() + size);
	}
}
