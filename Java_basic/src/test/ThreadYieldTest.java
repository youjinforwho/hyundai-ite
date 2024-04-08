package test;

class MyRunnable_4 implements Runnable {
	
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	private Thread t; //인스턴스 변수를 가져오기 위해 필드에 값 세팅해줌
	
	public void setThread(Thread t) { //현재 쓰고 있는 스레드를 지정하기 위한 메서드
		this.t = t;
	}
	
	@Override
	public void run() {
		while (!stopped) { //종료되지 않았고
			if (!suspended) { //중지되지 않았다면
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch(Exception e) {}
			} else { //busy waiting을 막고 프로그램의 효율성을 높이기 위해 yield 사용 -> 쓸데 없는 busy waiting은 프로그램 성능에 좋지 않음
				Thread.yield(); //static 메서드
			}
		}
		
	}
	
	public void suspend() {
		suspended = true;
		// thread에 대해 interrupt 걸기
		// thread에 대한 reference가 있어야 해당 thread를 처리할 수 있음
		// 해당 메서드 호출하자마자 스레드를 중지시키기 위해
		t.interrupt();
	}
	public void resume () {
		suspended = false;
	}
	public void stop() {
		stopped = true;
	}
}

public class ThreadYieldTest {
	
	public static void main(String[] args) {
		// Runnable 객체 생성
		MyRunnable_4 r1 = new MyRunnable_4(); 
		MyRunnable_4 r2 = new MyRunnable_4(); 
		MyRunnable_4 r3 = new MyRunnable_4(); 
		
		Thread t1 = new Thread(r1, "*"); //Thread의 이름 지정
		Thread t2 = new Thread(r2, "**");
		Thread t3 = new Thread(r3, "***");
		
		r1.setThread(t1);
		r2.setThread(t2);
		r3.setThread(t3);
		
		//어떤 스레드가 먼저 수행될지 알 수 없음
		//메인 스레드를 포함한 스레드 4개가 동시에 돌게 됨
		t1.start();
		t2.start();
		t3.start();
		
		try {
			//suspend, stop, resume은 인스턴스 메서드 => 특정 변수를 지정해서 동작하게 할 수 있음
			Thread.sleep(2000); //main thread가 sleep
			r1.suspend(); //스레드의 실행을 일시중지시킴 -> 지금은 deprecated됨
			Thread.sleep(2000);
			r2.suspend();
			Thread.sleep(3000);
			r1.resume(); //스레드 실행 재개
			Thread.sleep(3000);
			r1.stop(); //스레드 완전히 종료
			r2.stop();
			Thread.sleep(2000);
			r3.stop();
		} catch(Exception e) {}
	}
}
