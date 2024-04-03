package workshop04.calc;

public class Calc {
	public Calc() {
	}

	public int calculate(int data) {
		int result = 0;
		for (int i = 1; i <= data; i++) {
			if (i % 2 == 0) {
				result += i;
			}
		}
		return result;
	}
}
