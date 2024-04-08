package test;

class Shared {
	//해당 공유객체는 여러 Thread에 의해 같이 사용됨 -> 호출시 동기화시켜서 사용할 수 있도록
	public synchronized void printNum() {
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " : " + i);
				notify(); //lock을 놓겠다고 명시하고 놓기
				wait(); //해당 스레드는 wait 풀로 들어감
				//t1과 t2가 번갈아 수행되는 것을 보장할 수 있음
			}
		} catch(Exception e) {}
	}
}

class MyRunnable_10 implements Runnable {
	
	private Shared shared;
	
	public MyRunnable_10(Shared shared) {
		this.shared = shared;
	}
	@Override
	public void run() {
		shared.printNum(); //공유객체가 갖고 있는 print 메서드가 호출됨
	}
}

public class ThreadWaitNotiTest {
	public static void main(String[] args) {
		Shared obj = new Shared(); //공유 객체 생성
		Thread t1 = new Thread(new MyRunnable_10(obj));
		Thread t2 = new Thread(new MyRunnable_10(obj));
		
		t1.setName("첫번째 Thread");
		t2.setName("두번째 Thread");
		
		t1.start();
		t2.start();
		
	}
}
