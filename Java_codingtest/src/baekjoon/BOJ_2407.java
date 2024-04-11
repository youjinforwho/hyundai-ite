package baekjoon;
import java.math.BigInteger;
import java.util.*;

public class BOJ_2407 {
	public static BigInteger factorial(BigInteger num) {
		BigInteger big = new BigInteger("1");
		if (num.toString() == "1" || num.toString() == "0") return big;
		else {
			return num.multiply(factorial(num.subtract(big)));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int gap = n - m;
		BigInteger a = factorial(new BigInteger("" + n));
		BigInteger b = factorial(new BigInteger("" + gap));
		BigInteger c = factorial(new BigInteger("" + m));
		System.out.println(a.divide(b.multiply(c)));
	}
}
