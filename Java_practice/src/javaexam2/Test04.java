package javaexam2;
import java.util.*;

public class Test04 {
	public static void main(String[] args) {
		List list = new ArrayList();
		Random random = new Random();
		
		for (int i = 0; i < 10; i ++) {
			list.add(random.nextInt(10) + 1);
			System.out.print(list.get(i) + " ");
		}
		System.out.print("\n");
		
		//ArrayList의 값들을 Sorting 처리
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
