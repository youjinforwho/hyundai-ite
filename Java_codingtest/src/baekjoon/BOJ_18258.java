package baekjoon;
import java.util.*;
import java.io.*;

public class BOJ_18258 {
	public static void push(Queue<Integer> q, int num) {
		q.add(num);
	}
	public static void pop(StringBuilder sb, Queue<Integer> q) {
		if (!q.isEmpty()) {
			sb.append(q.element() + "\n");
			//System.out.println(q.element());
			q.remove();
		} else sb.append("-1" + "\n");//System.out.println(-1);
	}
	public static void size(StringBuilder sb, Queue<Integer> q) {
		sb.append(q.size() + "\n");
		//System.out.println(q.size());
	}
	public static void empty(StringBuilder sb, Queue<Integer> q) {
		if(q.isEmpty()) {
			sb.append("1" + "\n");//System.out.println(1);
		} else sb.append("0" + "\n");//System.out.println(0);
	}
	public static void front(StringBuilder sb, Queue<Integer> q) {
		if(!q.isEmpty()) {
			sb.append(q.element() + "\n");//System.out.println(q.element());
		} else sb.append("-1" + "\n");//System.out.println(-1);
	}
	public static void back(StringBuilder sb, Queue<Integer> q, int num) {
		if(!q.isEmpty()) {
			sb.append(num + "\n");//System.out.println(num);
		} else sb.append("-1" + "\n");//System.out.println(-1);
	}
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();

		int last = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			String order = st.nextToken();
			if (st.hasMoreTokens()) {
				last = Integer.parseInt(st.nextToken());
				push(q, last);
			}
			else {
				switch(order) {
				case "pop":
					pop(sb, q);
					break;
				case "size":
					size(sb, q);
					break;
				case "empty":
					empty(sb, q);
					break;
				case "front":
					front(sb, q);
					break;
				case "back":
					back(sb, q, last);
					break;
				}
			}
		}
		System.out.println(sb.toString());
 	}
}
