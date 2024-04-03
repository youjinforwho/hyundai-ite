package java1;

public class SuperClass {
	
	int a = 100;
	//String b = "여기는 super class";
	
	public SuperClass() {
		//super(); <- 상위 클래스인 Object 인스턴스를 만들기 위한 생성자 호출
	}
	
	public void myFunc() {
		System.out.println("super");
	}
}
