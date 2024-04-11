package baekjoon;
import java.io.*;
import java.util.ArrayList;

public class BOJ_2798 {
	public static ArrayList<Integer> array = new ArrayList<>();
	
	public static void combination (int n, int pick, int[] arr, int sum, int index) {
		if (pick == 3) {
			array.add(sum);
			return ;
		}
		else {
			for (int i = index; i < n; i++) {
				if ((pick == 1 || pick == 2) && i == index) {
					continue;
				} else {
					combination(n, pick + 1, arr, sum + arr[i], i);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] s1 = line.split(" ");
		int N = Integer.parseInt(s1[0]);
		int M = Integer.parseInt(s1[1]);
		
		String card = br.readLine();
		String[] s2 = card.split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s2[i]);
		}
		combination(N, 0, arr, 0, 0);
		int min = 2147483647;
		int gap;
		int res = 0;
		for (int i = 0; i < array.size(); i++) {
			gap = M - array.get(i);
			if ((min > gap) && (gap >= 0)) {
				min = gap;
				res = array.get(i);
			} 
		}
		System.out.println(res);
	}
}
