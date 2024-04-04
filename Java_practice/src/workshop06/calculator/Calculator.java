package workshop06.calculator;

public class Calculator {
	public Calculator() {
		
	}
	public double plus(int a, int b) {
		System.out.printf("결과:  %.1f", (double)(a + b));
		return a + b;
	}
	public double minus(int a, int b) {
		System.out.printf("결과:  %.1f", (double)(a - b));
		return a - b;
	}
	public double multiplication(int a, int b) {
		System.out.printf("결과:  %.1f", (double)(a * b));
		return a * b;
	}
	public double divide(int a, int b) {
		double res = 0;
		try {
			res = a / b;
		} catch(ArithmeticException e) {
			System.out.println("Exception이 발생 하였습니다. 다시 입력해 주세요\n결과: 0.0");
		}
		System.out.printf("결과:  %.1f", (double)(a / b));
		return res;
	}
}
