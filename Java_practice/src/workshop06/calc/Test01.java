package workshop06.calc;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		if (num < 5 || num > 10) System.out.println("다시 입력하세요");
		else {
			Calc cal = new Calc();
			System.out.println(cal.calculate(num));
		}
	}
}
