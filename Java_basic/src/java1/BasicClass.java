package java1;

public class BasicClass {
	//field
	private int a;
	private double b;
	
	//constructor
	BasicClass() {
		
	}
	
	//method
	//외부에서 값을 가져갈 수 있도록 해주는 특수한 형태의 메서드 -> getter, setter
	//Source > Generate Getters and Setters에서 알아서 만들어줌
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}
	
	
	//business method -> 어떤 로직을 수행하는 메서드

}
