package baekjoon;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_10845 {
	
	public static void pushQueue(Queue<Integer> q, int num) {
		q.add(num);
	}
	public static void popQueue(Queue<Integer> q) {
		if (q.isEmpty() != true) {
			System.out.println(q.remove());
		}
		else System.out.println(-1);
	}
	public static void sizeQueue(Queue<Integer> q) {
		System.out.println(q.size());
	}
	public static void isEmpty(Queue<Integer> q) {
		if (q.isEmpty() == true) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
	public static void frontQueue(Queue<Integer> q) {
		if (q.isEmpty() != true) {
			System.out.println(q.element());
		}
		else System.out.println(-1);
	}
	public static void backQueue(Queue<Integer> q, int num) {
		if (q.isEmpty() != true) {
			System.out.println(num);
		}
		else System.out.println(-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int last = 0;
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			String[] s = line.split(" ");
			
			if (s.length == 2) {
				pushQueue(q, Integer.parseInt(s[1]));
				last = Integer.parseInt(s[1]);
			}
			else {
				switch(s[0]) {
				case "pop":
					popQueue(q);
					break;
				case "size":
					sizeQueue(q);
					break;
				case "empty":
					isEmpty(q);
					break;
				case "front":
					frontQueue(q);
					break;
				case "back":
					backQueue(q, last);
					break;
				}
			}
				
		}
	}
}
