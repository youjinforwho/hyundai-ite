package test;

class Sleep_1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
		}
		try {
			//t1.sleep(2000); main 스레드는 잠 -> 인스턴스 variable 써도 현재 수행중인 스레드가 자게 됨
			//sleep은 static 메서드이고 현재 Thread를 재우는 메서드
		} catch (Exception e) {	
		}
		System.out.println("<< Thread 1 종료 >>");
	}
	
}

class Sleep_2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.println("<< Thread 2 종료 >>");
	}
}

public class ThreadSleepTest {
	public static void main(String[] args) {
		Thread t1 = new Sleep_1();
		Thread t2 = new Sleep_2();
		
		t1.start();
		t2.start();
		
	}
}
