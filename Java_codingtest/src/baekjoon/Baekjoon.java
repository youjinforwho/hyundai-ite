package baekjoon;
import java.util.*;
import java.io.*;

public class Baekjoon {
	public static void dfs(int virus, int[][] arr, int[] check) {
		for (int i = 0; i < check.length; i++) {
			if (check[i] != 1 && virus != i && arr[virus][i] == 1) {
				arr[virus][i] = 0;
				arr[i][virus] = 0;
				check[i] = 1;
				dfs(i, arr, check);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computer = Integer.parseInt(br.readLine());
		int link = Integer.parseInt(br.readLine());
		int[][] node = new int[computer][computer];
		int[] check = new int[computer];
		for (int i = 0; i < computer; i++) check[i] = 0;
		for (int i = 0; i < computer; i++) {
			for (int j = 0; j < computer; j++) {
				node[i][j] = 0;
			}
		}
		for (int i = 0; i < link; i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			
			node[x - 1][y - 1] = 1;
			node[y - 1][x - 1] = 1;
		}
		dfs(0, node, check);
		int cnt = 0;
		for (int i = 0; i < computer; i++) {
			if(i != 0 && check[i] == 1) cnt++;
		}
		System.out.println(cnt);
	}
}

