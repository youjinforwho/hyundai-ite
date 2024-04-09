package baekjoon;

import java.util.*;

public class BOJ_1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		int temp;
		int idx = 0;
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		while (!q.isEmpty()) {
			int cnt = 1;
			while (cnt != K) {
				cnt += 1;
				temp = q.element();
				q.remove();
				q.add(temp);
			}
			arr[idx] = q.element();
			q.remove();
			idx += 1;
		}
		System.out.print("<");
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.print(arr[i]);
			}
			else System.out.print(arr[i] + ", ");
		}
		System.out.println(">");
	}
}
