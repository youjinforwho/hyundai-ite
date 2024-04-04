package workshop04.account;

public class Account {
	private String account;
	private int balance;
	private double interestRate;
	
	public Account() {
		
	}
	public Account(String account, int balance, double interestRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getBalance() {
		return balance;
	}
	public double calculateInterest() {
		return balance * (interestRate / 100);
	}
	public void deposit(int money) {
		this.balance = getBalance() + money;
	}
	public void withdraw(int money) {
		this.balance = getBalance() - money;
	}
	public void accountInfo() {
		System.out.print("계좌번호:"+account+"\t잔액:"+balance+"\t이자율:"+interestRate);
	}
}
