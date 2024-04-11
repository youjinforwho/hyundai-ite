package echoanswer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EchoClientController implements Initializable {
	@FXML private TextField userID;
	@FXML private TextField userMsg;
	@FXML private Button sendMsg;
	@FXML private Button closeBtn;
	@FXML private TextArea messageBox;
	
	private Socket s;
	private BufferedReader br;
	private PrintWriter pw;
	String receiveMsg = null; 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//서버 접속하는 코드가 나오면 돼요
		try {
			Socket s = new Socket("localhost", 4444);
			br = new BufferedReader(new InputStreamReader(s.getInputStream())); //InputStream -> InputStreamReader -> BufferedReader로 확장(더 좋은 통로를 사용)
			pw = new PrintWriter(s.getOutputStream());
		} catch(Exception e) {
			
		}
		
		sendMsg.setOnAction(e -> {
			String msg = userID.getText() + " > " + userMsg.getText() + "\n";
			userID.clear();
			userMsg.clear();
			pw.println(msg);
			pw.flush(); //내부 버퍼를 갖고 있기 때문에 flush를 통해 외부로 보낼 수 있음
			try {
				receiveMsg = br.readLine(); //readLine역시 데이터를 받을때까지 기다리는 blocking method
			} catch(Exception e2) {
				
			}
			Platform.runLater(() -> {
				messageBox.appendText(receiveMsg);
			});
		});
	}
}
