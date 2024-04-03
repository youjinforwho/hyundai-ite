package javaexam2.company;

public class Secretary extends Employee implements Bonus{
	Secretary() {	
	}
	Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	@Override
	public double tax() {
		double tax = getSalary() * 0.1;
		return tax;
	}
	
	@Override
	public void incentive(int pay) {
		setSalary((int)(getSalary() + (pay * 0.8)));
	}
}
