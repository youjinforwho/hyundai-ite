package workshop04.account;

public class AccountTest2 {
	public static void main(String[] args) {
		
		Account[] account = new Account[5];
		for (int i = 0; i < 5; i++) {
			int rand = (int)(Math.random() * 5) + 1;
			account[i] = new Account("221-0101-2111" + rand, 100000, 4.5);
		}
		for (Account obj: account) {
			obj.accountInfo();
			System.out.println();
		}
		System.out.println();
		for (Account obj: account) {
			obj.setInterestRate(3.7);
			obj.accountInfo();
			System.out.printf("\t이자: %.1f\n", obj.calculateInterest());
		}
	}
}
