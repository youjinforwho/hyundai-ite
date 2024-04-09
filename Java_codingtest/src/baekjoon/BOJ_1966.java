package baekjoon;
import java.util.*;

public class BOJ_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			Queue<Integer> q = new LinkedList<>();
			Queue<Integer> r = new LinkedList<>();
			
			String line = sc.nextLine();
			String[] line_num = line.split(" ");
			int idx = 0;
			for (String s : line_num) {
				q.add(idx);
				r.add(Integer.parseInt(s));
				pq.add(Integer.parseInt(s));
				idx ++;
			}
			int cnt = 0;
			int temp;
			while (true) {
				if (r.element() == pq.element()) {
					cnt += 1;
					if (q.element() == M) break;
					q.remove();
					r.remove();
					pq.remove();
				} else {
					temp = r.element();
					r.remove();
					r.add(temp);
					temp = q.element();
					q.remove();
					q.add(temp);
				}
			}
			System.out.println(cnt);
			
		}	
	}
	
}
