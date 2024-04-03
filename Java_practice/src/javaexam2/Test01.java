package javaexam2;

public class Test01 {
	public static void main(String[] args) {
		int [][] array = {
			{12, 41, 36, 56},
			{82, 10, 12, 61},
			{14, 16, 18, 78},
			{45, 26, 72, 23}
		};
		double total = 0;
		double num = 0;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				total += array[i][j];
				num += 1;
			}
		}
		System.out.println("합계:"+total+"\n평균:"+(double)total/num);
	}
}
