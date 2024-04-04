package workshop04.account;

public class AccountTest {
	public static void main(String[] args) {
		Account account;
		account = new Account("441-0290-1203", 500000, 7.3);
		System.out.println("계좌정보:"+account.getAccount()+"\t현재잔액:"+account.getBalance());
		account.deposit(20000);
		System.out.println("계좌정보:"+account.getAccount()+"\t현재잔액:"+account.getBalance());
		System.out.println("이자:"+account.calculateInterest());
	}
}
