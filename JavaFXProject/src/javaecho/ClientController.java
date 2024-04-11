package javaecho;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClientController implements Initializable {
	@FXML private TextArea textArea;
	@FXML private Button sendBtn;
	@FXML private Button endBtn;
	@FXML private TextField textField;
	private Socket socket;
	private PrintWriter out;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Thread thread = new Thread() {
			public void run() {
				try {
					socket = new Socket("localhost", 9999);
					System.out.println("서버 접속에 성공하였습니다.");
					receiveMessage();
				}catch (Exception e) {
					if(!socket.isClosed()) {
						System.out.println("서버 접속에 실패하였습니다.");
						Platform.exit();
					}
				}
			}
		};
		thread.start();
		sendBtn.setOnAction(e -> {
			this.sendMessage();
		});
		endBtn.setOnAction(e -> {
			try {
				textArea.appendText("대화가 종료되었습니다");
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});		
	}
	
	public void receiveMessage() {
		while(true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String msg = br.readLine();
				System.out.println(msg);
				Platform.runLater(() -> {
					textArea.appendText(msg + "\n");
				});
			} catch(Exception e) {
				
			}
		}
	}
	
	public void sendMessage() {
		Thread thread = new Thread() {
			public void run() {
				try {
					out = new PrintWriter(socket.getOutputStream());
					out.println(textField.getText());
					out.flush();
					textField.clear();
				} catch (Exception e) {}
			}
		};
		thread.start();
	}
}