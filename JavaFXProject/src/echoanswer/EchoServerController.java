package echoanswer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

class MyRunnable implements Runnable {

	private Socket s;
	private BufferedReader br;
	private PrintWriter pw;
	
	public MyRunnable(Socket s) {
		this.s = s; //외부에 있는 객체의 생성자로 넘겨받은 소켓을 필드에 주입(Injection)
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		//서버쪽 socket이 동작하는 방식을 여기에 작성하면 됨
		//클라이언트가 메시지를 주는 걸 기다렸다가
		//메시지를 주면 바로 다시 클라이언트에게 전달하는 작업을 반복하면 됨 
		String msg = null;
		while (true) {
			try {
				msg = br.readLine(); //클라이언트가 나에게 메시지 줄때까지 대기
			} catch(Exception e) {
		
			}
			pw.println(msg);
			pw.flush();
		}
	}
}

//fxml에 의해 컨트롤러의 역할을 하려면 Initializable 인터페이스를 구현해줘야 함
public class EchoServerController implements Initializable {

	//id에 대한 레퍼런스 처리가 필요함
	@FXML private Button startBtn; //어노테이션을 붙여야 컨트롤러에 정의한 필드에 대한 실제 레퍼런스를 획득할 수 있음
	@FXML private TextArea messageBox;
	private void printMsg(String msg) {
		Platform.runLater(() -> {
			messageBox.appendText(msg + "\n");
		});
	}
	
	//컨트롤러가 만들어질때 이벤트에 대한 설정이 initialize에 의해서 실행됨
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		startBtn.setOnAction(e -> { //이벤트 처리시 handle이라는 메서드를 오버라이딩 해야 하는데 구현해야 하는 메서드가 하나밖에 없으므로 람다 사용해서 간편하게 정의 가능함
			//버튼이 클릭되면 처리해야 하는 코드를 여기에 넣어요
			//messageBox.appendText("서버가 시작되었어요"+"\n"); -> 간혹 출력이 안되는 경우가 있기 때문에 다른 방식을 이용하는 것이 좋음
			//thread-safe하게 동작될 수 있도록 함 => 순간적으로 스레드를 만들어서 실행이 되도록 하는 구조
//			Platform.runLater(new Runnable() {
//				//특정 컴포넌트를 제어하는 구문을 run 메서드 안에 정의 
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					
//				}
//				printMsg("서버가 시작되었어요");
				
				//이제 서버를 기동시키는 코드가 나와야 함 -> 서버 소켓 생성
				//로컬 변수이기 때문에 메서드 실행이 끝나면 날아감
				//리소스 해제 처리를 해야하기 때문에 로컬이 아니라 필드로 잡는 것이 좋음
				
				try {
					ServerSocket server = new ServerSocket(4444);
					//현재 수행되고 있는 스레드(UI 스레드)가 freezing => 별도의 스레드로 만들어서 처리를 해줘야 함 (UI 화면 스레드-대기하는 스레드 분리)
					//UI 스레드가 block되어 실행되지 못하는건 피해줘야 함
					new Thread(() -> {
						try {
							printMsg("서버가 시작되었어요");
							while (true) {
								Socket s = server.accept();
								//클라이언트가 접속해서 만들어진 socket을 이용해서 통신처리를 담당하는 Thread를 만들어서 실행해야 됨
								//클라이언트가 들어올때마다 새로운 스레드가 생성되서 실행됨
								MyRunnable r = new MyRunnable(s); //클라이언트와 논리적으로 연결된 소켓 정보를 넘겨서 실행
								Thread t = new Thread(r);
								t.start();
							}
							//이 accept가 반복적으로 실행되기 위해서는 -> while문 사용
						} catch(Exception e2) {
							
						}
					}).start();
				} catch(Exception e2) {
					
				}
			});
	}
	
}
