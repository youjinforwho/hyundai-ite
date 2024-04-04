package test;

class MyThread1 extends Thread {
	
	public MyThread1(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName());
		}
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()); //static이 붙으면 글자가 누움 -> 인스턴스가 없어도 사용가능, 현재 수행되고 있는 쓰레드 호출
		}
	}
}
public class ThreadTest3 {
	public static void main(String[] args) {
		
		MyThread1 t1 = new MyThread1("홍길동"); //Thread의 이름을 홍길동으로 설정
		
		MyRunnable r = new MyRunnable();
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
	}
}
