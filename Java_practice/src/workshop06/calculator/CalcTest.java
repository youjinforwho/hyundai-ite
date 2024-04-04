package workshop06.calculator;
import java.util.*;

public class CalcTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fx = sc.nextLine();
		String[] s = fx.split(" ");
		if (s.length != 3) System.out.println("다시 입력 하세요");
		else {
			int num1 = Integer.parseInt(s[0]);
			int num2 = Integer.parseInt(s[2]);
			char operator = s[1].charAt(0);
			Calculator cal = new Calculator();
			switch(operator){
				case '+':
					cal.plus(num1, num2);
					break;
				case '-':
					cal.minus(num1, num2);
					break;
				case '*':
					cal.multiplication(num1, num2);
					break;
				case '/':
					cal.divide(num1, num2);
					break;
			}
		}
	}
}
