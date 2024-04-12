package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24511 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Deque<Integer> dq = new ArrayDeque();
		int cnt = 0;
		
        //각각 자료구조의 개수만큼 어떠한 자료구조를 가지는지 입력받기(큐 or 스택)
		st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            // 일단 자료구조형태값만 받는다.
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 0) cnt++;
        }
        
        st = new StringTokenizer(br.readLine());
		//각 자료구조에 들어가있는 값 저장하기
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (arr[i] == 0) {
				dq.addLast(num);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		//자료구조에 들어오는 값 찾아 반환값 출력하기
		int ret = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (dq.isEmpty()) ret = temp;
			else {
				ret = dq.pollLast();
				dq.addFirst(temp);
			}
			sb.append(ret + " ");
		}
		System.out.println(sb.toString());
	}
}
