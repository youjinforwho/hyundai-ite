package java1;

public class Main {
	
	public static void main(String[] args) {
		
		//instance 생성 
		SuperClass sub = new SubClass();
		System.out.println(sub.a);//5000
		sub.myFunc();
	}
}
