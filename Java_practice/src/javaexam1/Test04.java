package javaexam1;

public class Test04 {
	public static void main(String[] args) {
		int i = 1;
		int result = 0;
		
		while (i <= 100) {
			result += i;
			i += 1;
		}
		System.out.println("합계:" + (double)result + "\n평균:" + (double)result/100);
	}
}
