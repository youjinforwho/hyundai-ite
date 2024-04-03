package java2;

import java.util.ArrayList;
import java.util.List;

class MyStudent {
	
}

public class ArrayListTest {
	public static void main(String[] args) {
		
		//ArrayList 객체를 만들어서 사용해 보아요
		//ArrayList list = new ArrayList();
		//List계열은 객체면 type에 상관없이 다 저장이 가능함
		//다른 reference data type들을 저장할 수 있음(배열과의 차이)
		List list = new ArrayList(); //일반적으로 상위 인터페이스의 타입으로 명시해줌
		//실제로 구현하다보면 거의 예외없이 같은 데이터 타입을 이용해서 사용하게 됨(Like 배열)
		//List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add(new MyStudent());
		list.add(100);
		//100은 int형태의 primitive type -> ArrayList 안에 저장될 수 없음
		//그럼에도 에러가 안나고 저장되는 이유? -> Java는 원시 타입에 각각 대응되는 wrapper class가 존재하기 때문
		//list.add(100); => list.add(new Integer(100)) -> boxing 한다고 표현
		//자동으로 싸주기 때문에 auto-boxing이라고 함
		
//		for (int i = 0; i < 10; i++) {
//			
//		}
		//list에 있는 것만큼 출력
		for (Object obj: list) {
			System.out.println(obj.toString());
		}
		
		//명시해서 쓰면 편하게 사용할 수 있음
		List<String> myList = new ArrayList<String>();
		myList.add("홍길동");
		myList.add("신사임당");
		
		for (String str: myList) {
			System.out.println(str);
		}
	}
}
