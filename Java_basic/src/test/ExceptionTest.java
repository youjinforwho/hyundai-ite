package test;

public class ExceptionTest {
	public static void main(String[] args) {
		System.out.println("예외상황을 발생시켜보아요");
		try {
//			int result = 10 / 0; //Exception 발생
			ExceptionTest t  = null; //가리키고 있는 메모리 주소값이 없음 -> 객체를 갖고 메서드 호출하거나 필드 사용 불가
			System.out.println(t.toString()); //NullPointerException
//		} catch(Exception e) {
//			
//		}
		} catch(ArithmeticException e) {
			System.out.println("처리완료");
		} catch(NullPointerException e) {
			System.out.println("NullPointer처리 완료!");
		} finally {
			System.out.println("이놈은 무조건 수행돼요");
		}
		System.out.println("이거 수행되네요!!");
	}
}
