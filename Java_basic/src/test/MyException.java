package test;

public class MyException extends Exception {
	public static void main(String[] args) {
		try {
			throw new MyException(); //예외를 발생시키려면 내가 직접 만들고 던져야 함
		} catch(Exception e) {
			System.out.println("사용자 정의 Exception 발생");
		}
	}
}
