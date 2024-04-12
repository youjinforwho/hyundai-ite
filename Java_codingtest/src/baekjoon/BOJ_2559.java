package baekjoon;
import java.util.*;

public class BOJ_2559 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int max = -2147483648;
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (i == 0) arr[i] = num;
			else arr[i] = arr[i - 1] + num;
		}
		int temp;
		if (K == N) System.out.println(arr[N - 1]);
		else if (K == 1) {
			if (arr[0] > max) max = arr[0];
			for (int i = 1; i < N; i++) {
				temp = arr[i] - arr[i - 1];
				if (temp > max) max = temp;
			}
			System.out.println(max);
		}
		else {
			for (int i = K - 1; i < N; i++) {
				if (i == K - 1) {
					temp = arr[i];
				} else {
					temp = arr[i] - arr[i - K];
				}
				if (temp > max) max = temp;
			}
			System.out.println(max);
		}
		sc.close();
	}
}
