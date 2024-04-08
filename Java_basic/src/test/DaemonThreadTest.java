package test;

public class DaemonThreadTest implements Runnable {
	
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		Thread t = new Thread(new DaemonThreadTest());
		t.setDaemon(true); //데몬스레드로 사용하겠다고 설정
		t.start(); //언젠가는 이 thread가 동작하게 됨
		
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000); //현재 수행되고 있는 스레드를 재움 -> 인스턴스를 이용해서 재우면 X
			} catch(Exception e) {
				System.out.println("오류발생!");
			}
			System.out.println("i의 값은: " + i);
			if (i == 5) {
				autoSave = true;
			}
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000); //3초간 재우기
			} catch (Exception e) {
				System.out.println("오류발생!"); //자는 도중에 누가 방해하면 예외 발생
			} 
			
			if (autoSave) {
				System.out.println("자동저장되었습니다.");
			}
		}
	}
}
