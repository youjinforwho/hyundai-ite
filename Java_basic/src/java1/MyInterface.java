package java1;

public interface MyInterface {
	
	//field -> 생략 가능
	//public static final int MY_NUM = 100;
	int MY_NUM = 100;
	
	//only abstract method -> 생략 가능 (자동적으로 삽입됨)
	//public abstract void myFunc();
	void myFunc();
}

class MyClass1 implements MyInterface {
	@Override
	public void myFunc() {
		
	}
}