package javaexam1.calc;

import java.util.Scanner;

public class Calc {
	
	public Calc() {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		sc.close();
		
		System.out.println("합:"+this.sum(a, b));
		System.out.println("차:"+this.subtract(a, b));
		System.out.println("곱:"+this.multiply(a, b));
		System.out.println("나누기:"+this.divide(a, b));
	}

	public int sum(int a, int b) {
		return a + b;
	}
	public int subtract(int a, int b) {
		return a - b;
	}
	public int multiply(int a, int b) {
		return a * b;
	}
	public int divide(int a, int b) {
		if (b <= 0) return 0;
		else return a / b;
	}
}
