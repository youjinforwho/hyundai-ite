//package는 관련있는 class들을 하나로 묶는 논리적인 단위이고 물리적으로는 폴더로 표현됨
package java1;

//하나의 자바 파일에 public이 붙은 class는 두 개 이상 존재할 수 없음(하나만 있어야)
//만약 public class가 존재하면 파일명은 반드시 public class 이름으로 설정해야 함
public class HelloWorld {
	
	//field들
	int age;
	
	//constructor들
	//constructor는 이름이 클래스 이름과 같다 -> 모양은 method와 유사, But 리턴타입 존재 X
	//생성자를 명시하지 않으면 javac compiler가 소스코드를 bytecode로 컴파일 할 때 기본생성자를 자동으로 삽입
	//default constructor는 직접 작성해주는 것이 좋다
	public HelloWorld( ) {
		//instance 초기화 담당
	}
	
	//method들
	public void sayHello() {
		System.out.println("Hello");
	}
	
	//프로그램의 entry point가 필요함 -> 형식이 정해져 있음
	public static void main(String args[]) {
		System.out.println("Hello");
		
		//인스턴스 생성 -> 메모리 공간 중 힙 영역에 들어감
		//래퍼런스 변수를 함께 선언해주어야 인스턴스를 사용할 수 있음
		//자바는 강한타입 언어이기 때문에 클래스 타입(클래스 이름)을 명시해줘야 함
		HelloWorld a = new HelloWorld();
		a.sayHello();
		
		
	}
}
