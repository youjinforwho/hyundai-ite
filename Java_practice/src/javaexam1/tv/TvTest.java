package javaexam1.tv;

import java.lang.reflect.Array;

public class TvTest {
	public static void main(String[] args) {
		Tv tvArray [] = new Tv[3];
		tvArray[0] = new Tv("INFINIA", 1500000, "LED TV");
		tvArray[1] = new Tv("XCANVAS", 1000000, "LCD TV");
		tvArray[2] = new Tv("CINEMA", 2000000, "3D TV");
	int total = 0;
	for (int i = 0; i < 3; i++) {
		System.out.println(tvArray[i].toString());
		total += tvArray[i].getPrice();
	}
	System.out.println("가격의 합:"+total);
	}
}
