package javaexam2;

import java.util.HashMap;
import java.util.Random;

public class Test05 {
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		Random random = new Random();
		
		double sum = 0.0;
		
		for (int i = 0; i < 10; i ++) {
			map.put(i + 1, random.nextInt(100) + 1);
			sum += map.get(i + 1);
		}
		System.out.printf("합계:%.2f\n평균:%.2f", sum, (sum / map.size()));
	}
}
