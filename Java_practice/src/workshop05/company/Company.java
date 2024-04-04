package workshop05.company;

public class Company {
	private double salary;
	private double annualIncome;
	private double afterTaxAnnualIncome;
	private double afterTaxBonus;
	
	public Company() {
		
	}
	public Company(double salary) {
		this.salary = salary;
	}
	public double getIncome() {
		return salary * 12;
	}
	public double getAfterTaxIncome() {
		double tax = salary * 0.1;
		return (salary - tax) * 12;
	}
	public double getBonus() {
		return salary * 4 * 0.2;
	}
	public double getAfterTaxBonus() {
		double bonus = salary * 0.2;
		double tax = bonus * 0.55;
		return (bonus - tax) * 4;
	}
}
