package workshop06.account;

public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account("441-0290-1203", 500000.0, 7.3);
		System.out.println("계좌정보: " + account.getAccount() +'\t'+ account.getBalance() +'\t'+ account.getInterestRate());
		try {
			account.deposit(-1);
		} catch(Exception e) {
			System.out.println("입금 금액이 0보다 적습니다.");
		}
		try {
			account.withdraw(600000); 
		} catch (Exception e) {
			System.out.println("금액이 0보다 적거나 현재 잔액보다 많습니다.");
		}
		System.out.println("이자: " + account.calculateInterest());
	}
}
