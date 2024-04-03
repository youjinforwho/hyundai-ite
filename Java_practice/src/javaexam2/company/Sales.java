package javaexam2.company;

public class Sales extends Employee implements Bonus{
	public Sales() {
		
	}
	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	@Override
	public double tax() {
		double tax = getSalary() * 0.13;
		return tax;
	}
	@Override
	public void incentive(int pay) {
		setSalary((int)(getSalary() + pay * 1.2));
	}
}
