package baekjoon;

import java.util.*;

public class BOJ_4673 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= 10000; i++) {
			int num = i;
			int temp = i;
			while (temp != 0) {
				num += (temp % 10);
				temp /= 10;
			}
			set.add(num);
		}
		for (int i = 1; i <= 10000; i++) {
			if (!set.contains(i)) {
				System.out.println(i);
			}
		}
	}
}
