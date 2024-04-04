package test;

public class ThreadTest2 {
	public static void main(String[] args) {
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}); //인터페이스이기 때문에(추상 메서드가 있기 때문에) 해당 메서드를 지정해준 후 바로 사용 가능
		
		new Thread(() -> { //람다식 사용해서 축약
			System.out.println("복잡해서 줄였어요");
		}
		).start();
	}
}
