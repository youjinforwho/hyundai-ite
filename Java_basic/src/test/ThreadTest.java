package test;

class MyThread extends Thread{ //Thread안에 있는 run은 추상 메서드 X
	
	@Override
	public void run() {
		//Thread의 실행코드 작성
		System.out.println("여기는 첫번째 Thread");
	}

}

//class MyRunnable implements Runnable { //Runnable안에 있는 run은 추상 메서드
//	@Override
//	public void run() {
//		//Thread의 실행코드 작성
//		System.out.println("여기는 두번째 Thread");
//	}
//}

public class ThreadTest {
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread(); //Thread를 생성 
		t1.start(); //thread의 실행 -> main Thread와 동시에 실행되게 됨
		//start()는 non-blocking method
		//blocking method는 메서드가 종료되기 전(리턴값을 주기 전)까지 대기하고 있는 메서드
		//start()는 thread schduler에게 thread를 실행시켜 달라고 요청하는 method
		
		MyRunnable r = new MyRunnable(); //Runnable 인터페이스를 구현한 객체
		Thread t2 = new Thread(r); //Thread 클래스를 새로 생성하여 MyRunnable객체를 쓰레드화(?)
		t2.start();
		
	}
}
