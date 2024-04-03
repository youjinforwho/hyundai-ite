package javaexam1;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		if (num % 2 == 0) {
			System.out.println("2의 배수 입니다.");
		}
		else {
			System.out.println("2의 배수가 아닙니다.");
		}
	}
}
