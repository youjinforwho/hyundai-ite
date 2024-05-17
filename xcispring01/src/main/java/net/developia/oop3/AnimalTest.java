package net.developia.oop3;

public class AnimalTest {
	public static void main(String[] args) {
//		Animal a = new Animal();
//		System.out.println(a);
//		
//		if (a instanceof Bird) {
//			Bird b = (Bird) a;
//			System.out.println(b);
//		} else {
//			System.out.println("다운 캐스팅 불가");
//		}
		
		Bird b = new Bird();
		Animal a = b;
		if (a instanceof Bird) {
			Bird b2 = (Bird) a;
			System.out.println(a);
			if (b instanceof Condor) {
				Condor c = (Condor) b2;
				System.out.println(c);
			} else {
				System.out.println("err3");
			}
		} else {
			System.out.println("err");
		}
	}
}
