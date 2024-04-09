package baekjoon;
import java.util.*;

public class BOJ_2003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int cnt = 0;
		
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (i == 0) arr[i] = num;
			else arr[i] = arr[i - 1] + num;
			if (arr[i] == M) cnt += 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (arr[j] - arr[i] == M) cnt += 1;
			}
		}
		System.out.println(cnt);
	}
}
