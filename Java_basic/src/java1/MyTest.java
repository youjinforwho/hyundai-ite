package java1;

public class MyTest {
	//필드들 -> 인스턴스가 있어야 사용할 수 있기 때문에 instance variable이라고 부르기도 함
	//instance variable은 heap 영역에 만들어짐
	public int a = 100;
	
	//static variable(class variable)은 method 영역에 만들어짐 -> 클래스 생성시 같이 만들어지기 때문에 인스턴스 없이 사용 가능
	//여러 인스턴스가 만들어져도 static variable은 하나만 만들어져서 공유됨
	static int b = 200;
	
	private int c = 300;
	
	//생성자들	
	public MyTest() {
		
	}
	
	//메서드들
	public static void main(String[] args) {
		//System.out.println("a의 값은: " + a); 인스턴스를 먼저 만들어줘야 함 -> 그 이전까지 a는 메모리 공간에 존재하지 X
		MyTest obj = new MyTest();
		
		//obj는 실제 객체가 아님 -> 객체를 가리키는 주소값이 담긴 레퍼런스 변수
		//obj를 통해 Heap 영역에 생성된 instance를 사용할 수 있음
		//reference variable을 이용해서 instance를 사용할 때 이용하는 연산자 -> dot operator(.)
		System.out.println("a의 값은: " + obj.a);
		
		//지역 변수 -> 메서드 내에서 실행됨
		//local variable은 stack 영역에 만들어짐
		int k = 200;
	}
}
