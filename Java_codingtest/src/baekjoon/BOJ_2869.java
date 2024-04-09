package baekjoon;
import java.util.*;

public class BOJ_2869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		double day = (double)(V - B) / (A - B);
		if ((int)day == (double)(V - B) / (A - B)) {
			System.out.println((int)day);
		}
		else System.out.println((int)day + 1);
		sc.close();
	}
}
