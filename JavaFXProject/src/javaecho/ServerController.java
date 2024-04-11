package javaecho;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class ServerController implements Initializable {
	@FXML private Button startBtn;
	@FXML private TextArea textArea;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	public static ExecutorService threadPool;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		textArea.setText("서버 시작하기 버튼을 누르면 서버가 시작됩니다.");
		startBtn.setOnAction(e -> {
			try {
				serverSocket = new ServerSocket(9999);
			} catch(Exception error) {
				
			}
			textArea.clear();
			System.out.println("서버가 열렸습니다.");
			this.startServer();
		});
	}
	
	public void startServer() {
		Runnable thread = new Runnable() {
			public void run() {
				while(true) {
					try {
						clientSocket = serverSocket.accept();
						String info = clientSocket.getRemoteSocketAddress().toString();
						textArea.appendText("새로운 클라이언트가 접속했습니다.\n" + "클라이언트 정보: " + info + "\n");
						echoMessage(clientSocket);
					} catch(Exception e) {
						
					} 
				}
			}
		};
		threadPool = Executors.newCachedThreadPool();
		threadPool.submit(thread);
	}
	//받은 내용을 그대로 클라이언트에게 돌려줌
	public void echoMessage(Socket clientSocket) {
		Runnable thread = new Runnable() {
			public void run() {
				while (true) {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
						String msg = br.readLine();
						out = new PrintWriter(clientSocket.getOutputStream());
						out.println(msg);
						out.flush();
					} catch(Exception e) {
						
					}
				}
			}
		};
		ServerController.threadPool.submit(thread);
	}
}
