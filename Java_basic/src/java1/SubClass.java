package java1;

public class SubClass extends SuperClass{
	// 추가적인 field와 method를 정의하면 됨
	int c = 500;
	
	int a = 5000; //shadow
	int b = 500;
	
	public SubClass() {
		//현재 class가 최상위 클래스인지 확인하고 아니면
		//상위 클래스의 instance를 만드는 코드가 들어가야 함
		super(); //상위 클래스의 생성자를 찾아 호출하는 함수 -> 안써도 알아서 컴파일 단계에서 만들어줌
	}
	
	@Override // 어노테이션 -> 지시자
	public void myFunc() {
		System.out.println("여기는 subclass에요...");
	}
}
