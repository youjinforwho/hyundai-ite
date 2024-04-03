package workshop04;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] arr = s.split(" ");
		if (arr.length != 2) {
			System.out.println("다시 입력 하세요");
		} else {
			int num1 = Integer.parseInt(arr[0]);
			int num2 = Integer.parseInt(arr[1]);
			
			if (num1 < 1 && num1 > 5 && num2 < 1 && num2 > 5) {
				System.out.println("숫자를 확인 하세요");
			}
			else {
				int[][] array = new int[num1][num2];
				for (int i = 0; i < num1; i++) {
					for (int j = 0; j < num2; j++) {
						array[i][j] = ((int)Math.random() * 100) + 1;
					}
				}
			}
			
		}

	}
}
