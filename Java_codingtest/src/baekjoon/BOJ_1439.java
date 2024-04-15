package baekjoon;
import java.io.*;

public class BOJ_1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String[] s1 = S.split("0");
		int num0 = 0;
		int num1 = 0;
		String[] s2 = S.split("1");
		for (String s: s1) {
			if (s.length() != 0) num0++;
		}
		for (String s: s2) {
			if (s.length() != 0) num1++;
		}
		if (num0 > num1) System.out.println(num1);
		else System.out.println(num0);
	}
}
