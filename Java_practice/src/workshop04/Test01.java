package workshop04;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		int[] arr =  {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		Arrays.sort(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
	}
}
