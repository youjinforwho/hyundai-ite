package baekjoon;

import java.util.Scanner;

public class BOJ_2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			StringBuilder sb = new StringBuilder();
			int R = sc.nextInt();
			String S = sc.next();
			for (int j = 0; j < R; j++) {
				sb.append(S);
			}
			System.out.println(sb.toString());
		}
	}
	
}
