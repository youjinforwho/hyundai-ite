package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s1 = br.readLine().split(" ");
		int N = Integer.parseInt(s1[0]);
		int M = Integer.parseInt(s1[1]);
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (s.length() >= M) {
				if (map.containsValue(s)) {
					map.put(s, map.get(s) + 1);
				} else {
					map.put(s, 1);
				}
			}
		}
		List<String> list = Collections.sort(map, new Comparator<String, Integer>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (map.get(o1) != map.get(o2)) return (map.get(o1) - map.get(o2));
				else {
					if (o1.length() != o2.length()) {
						return o2.length() - o1.length();
					}else {
						return o1.compareTo(o2);
					}
				}
			}
		});
		for(Map.Entry<String, Integer> entry: list) {
			System.out.println(entry.getKey());
		}
	}
}
