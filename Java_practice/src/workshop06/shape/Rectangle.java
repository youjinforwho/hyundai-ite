package workshop06.shape;

public class Rectangle extends Shape implements Resize{
	Rectangle() {
		
	}
	Rectangle(int width, int height, String colors) {
		super(width, height, colors);
	}
	@Override
	public double getArea() {
		return getWidth() * getHeight() * 0.5;
	}
	public void setResize(int size) {
		setWidth(getWidth() + size);
	}
}
