package javaecho;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class ServerController implements Initializable {
	@FXML private Button startBtn;
	@FXML private TextArea textArea;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		startBtn.setOnAction(e -> {
			try {
				ServerSocket serverSocket = new ServerSocket(9999);
				System.out.println("서버가 열렸습니다.");
				Socket clientSocket = serverSocket.accept();
				
				while (true) {
					InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream()); //InputStream을 얻어냄 -> 조금 더 좋은 inputstream으로 확장
					BufferedReader br = new BufferedReader(isr);
					String msg = br.readLine(); //한 줄을 받겠다는 의미
					textArea.appendText(msg + "\n");
				}
				
			} catch(Exception error) {error.printStackTrace();}
		});
	
	}
}
