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
			String[] arr = S.split("");
			for (int idx = 0; idx < arr.length; idx++) {
				for (int iter = 0; iter < R; iter++)	
					sb.append(arr[idx]);
			}
			System.out.println(sb.toString());
			
		}
	}
	
}
