package baekjoon;

import java.util.Scanner;

public class BOJ_11659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (i > 0) {
				arr[i] = arr[i-1] + num;
			}
			else arr[i] = num;
		}
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt() - 2;
			int to = sc.nextInt() - 1;
			if (from == -1) {
				System.out.println(arr[to]);
			}
			else {
				System.out.println(arr[to] - arr[from]);
			}
		}
	}
}
