package workshop05;
import java.util.*;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] arr = s.toCharArray();
		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
	}
}
