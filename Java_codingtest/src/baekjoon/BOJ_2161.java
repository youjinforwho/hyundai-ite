package baekjoon;
import java.util.*;

public class BOJ_2161 {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		int last = 0;
		int temp;
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		while (!q.isEmpty()) {
			last = q.element();
			System.out.print(last + " ");
			q.remove();
			if (!q.isEmpty()) {
				temp = q.element();
				q.remove();
				q.add(temp);
			}
		}
	}
}
