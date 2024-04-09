package programmers;

import java.util.HashMap;
import java.util.Set;

public class pro_ponketmon {
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		boolean answer = true;
		HashMap<String, Integer> hash = new HashMap<>();
		for (String s : phone_book) {
			hash.put(s, s.length());
		}
		for (String s : hash.keySet()) {
			int len = hash.get(s);
			for (String find: hash.keySet()) {
				if (hash.get(find) > len) {
					String shorten = find.substring(0, len);
					if (s.compareTo(shorten) == 0) answer = false;
				}
			}
		}
		System.out.println(answer);
	}
}