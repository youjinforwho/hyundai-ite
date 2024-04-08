package test;

// (스레드에 의해 공유되는)공유 자원 define
// 공유 객체를 만들어 사용
class Account {
	private int balance = 1000; //잔액
	
	//잔액 조회 메서드
	public int getBalance() {
		return balance;
	}
	
	//출금하는 메서드
	//임계영역(Critical Section)을 설정해줘서 lock을 획득할 수 있도록 해주는 키워드
	//순차처리되기 때문에 몇가지 문제점 발생
	//이런 문제를 해결하기 위해 일반적으로는 synchronized block을 이요앟ㅁ
	public void withdraw(int money) {
		if (balance > money) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
		//실제 동기화되는 부분만 동기화 블록을 사용하여 임계영역을 줄임
		//여기서 this는 account 객체
		synchronized(this) { 
			balance -= money;
		}
	}
}

class MySyncRunnable implements Runnable {
	
	Account acc = new Account(); //공용객체
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		while (acc.getBalance() > 0) {
			int money = (int)(Math.random() * 100) + 1;
			acc.withdraw(money);
			System.out.println(Thread.currentThread().getName());
			System.out.println("잔액은 : " + acc.getBalance());
 		}
	}
}

public class ThreadSyncTest {
	public static void main(String[] args) {
		MySyncRunnable r = new MySyncRunnable();
		
		//같은 Runnable 객체를 갖고 스레드 2개를 만듦 -> 공용객체를 같이 사용하게 됨
		Thread t1 = new Thread(r, "t1");
		Thread t2 = new Thread(r, "t2");
		
		//t1과 t2가 경쟁적으로 공유 객체를 사용하려고 함
		t1.start();
		t2.start();
	}
}
