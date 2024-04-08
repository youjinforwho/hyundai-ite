package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StreamTest {
	public static void main(String[] args) {
		//키보드로 한 line을 입력받아 그대로 출력하기
		//표준입력(키보드 입력) System.in => 불편함(한글자씩 입력)
		//표준출력(모니터 출력) System.out
		InputStreamReader isr = new InputStreamReader(System.in);
		//InputStreamReader는 문자단위로 입력받을 수 있음
		//한 line 단위로 입력받을 수 있음
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String msg = br.readLine();
			System.out.println("입력받은 데이터: " + msg);
		} catch(Exception e) {}
	
	}
}
