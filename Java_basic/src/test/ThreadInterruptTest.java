package test;
import javax.swing.*; //GUI를 하기 위해 제공되는 컴포넌트

class MyThread_3 extends Thread {
	@Override
	public void run() {
		int i = 10;
		
		while (i != 0 && !isInterrupted()) {
			System.out.println(i--);
			try {
				Thread.sleep(4000);
			} catch (Exception e) { //sleep 중에 InterruptedException이 발생되면 state가 초기화됨 true-> false
				interrupt(); //true로 다시 바꿔줘야 함
			}
			
		}
		System.out.println("카운트가 종료되었습니다.");
	}
}

public class ThreadInterruptTest {
	public static void main(String[] args) {
		Thread t = new MyThread_3();
		t.start();
		
		//약간의 시간지연을 위해 Swing 이용
		String input = JOptionPane.showInputDialog("값을 입력하세요"); //값 입력하기 전까지 중지(blocking method) -> 확인하기 전까지 메인 메서드가 중지됨
		System.out.println("입력된 값은: " + input);
		
		t.interrupt();
	}
}