package baekjoon;
import java.util.*;
import java.io.*;

public class BOJ_24511 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		int[] arr3 = new int[N];

		String[] s1 = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(s1[i]);
		}
		String[] s2 = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr2[i] = Integer.parseInt(s2[i]);
		}
		int M = Integer.parseInt(br.readLine());;
		String[] s3 = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			arr3[i] = Integer.parseInt(s3[i]);
			int C = arr3[i];
			int ret = 0;
			int temp;
			for (int j = 0; j < N; j++) {
				if (j == 0) {
					if (arr1[j] == 0) { //큐라면
						ret = arr2[j];
						arr2[j] = C;
					} else { //스택이라면
						ret = C;
					}
				} else {
					if (arr1[j] == 0) {
						temp = arr2[j];
						arr2[j] = ret;
						ret = temp;
					} else {
						continue;
					}
				}
			}
			sb.append(ret + " ");
		}
		System.out.println(sb.toString());
	}
}
