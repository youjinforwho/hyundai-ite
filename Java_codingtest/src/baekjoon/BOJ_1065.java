package baekjoon;

import java.util.Scanner;

public class BOJ_1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[1000];
		
		//한수 구하기
		for (int i = 1; i <= 1000; i++) {
			int temp = i;
			boolean flag = true;
			int idx = 0;
			int gap = 0;
			while (temp != 0) {
				int num = temp % 10;
				if (idx == 0) continue;
				else {
					
				}
				temp /= 10;
			}
			if (flag == true) arr[idx] = i;
		}
	}
}
