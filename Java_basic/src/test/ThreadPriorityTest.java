package test;


public class ThreadPriorityTest {
	
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()); //현재 코어에 의해 실행되고 있는 스레드 이름 출력
			}
		}
		);
		t1.setPriority(1); //스레드 우선순위 설정
	
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName());
			}
		}
		);
		t2.setPriority(10);
		
		t1.start();
		t2.start();
	}
}
