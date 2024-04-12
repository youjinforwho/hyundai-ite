package baekjoon;

import java.util.Scanner;

public class BOJ_2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		int res = -1;
		for (int i = 1; i <= N; i++) {
			int temp = i;
			sum = i;
			while (temp > 0) {
				sum += (temp % 10);
				temp /= 10;
			}
			if (sum == N) {
				res = i;
				break;
			}
		}
		if (res != -1) {
			System.out.println(res);
		}else System.out.println(0);
	}
}
