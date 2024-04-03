package java1;

public abstract class TestA {
	//field
	private int age;
	private String name;
	
	//constructor
	public TestA() {
		
	}
	
	//constructor overloading
	public TestA(int age, String name) {
		super(); //없어도 자동으로 삽입됨
		this.age = age;
		this.name = name;
	}
	
	//method
	public void myFunc() {
		//method 정의
	}
	
	public abstract void sayHello(); //method의 선언 => abstract method(추상 메서드)
}

class MySubClass extends TestA {
	@Override 
	public void sayHello() {
		
	}
}