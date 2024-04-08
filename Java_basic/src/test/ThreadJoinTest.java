package test;

class MyThread_8 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("-");
		}
	}
}

class MyThread_9 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println("|");
		}
	}
}

public class ThreadJoinTest {
	public static void main(String[] args) {
		MyThread_8 t1 = new MyThread_8();
		MyThread_9 t2 = new MyThread_9();
		
		t1.start();
		t2.start();
		
		try {
			t1.join(); //main이 뒤로 밀림 -> t1이 끝날 때까지 대기상태에 들어감
			t2.join();
		} catch (Exception e) {
			
		}
	}
}
