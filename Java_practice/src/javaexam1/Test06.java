package javaexam1;

public class Test06 {
	
	public static void main(String[] args) {
		int [] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int total = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) {
				System.out.println(array[i]);
				total += array[i];
			} else continue;
		}
		System.out.println("합계:" + (double)total);
	}
}
