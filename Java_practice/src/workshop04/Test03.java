package workshop04;
import java.util.*;

public class Test03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int n = sc.nextInt();
		for (int i = n; i <= 10; i++) {
			if (i % 3 != 0 && i % 5 != 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
}
