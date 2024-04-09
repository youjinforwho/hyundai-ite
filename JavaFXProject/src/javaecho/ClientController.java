package javaecho;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

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
	protected Socket socket;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			//서버로의 접속 시도
			Socket s = new Socket("localhost", 9999);
			System.out.println("접속 성공!!");
			sendBtn.setOnAction(e -> {
				PrintWriter out;
				try {
					out = new PrintWriter(s.getOutputStream());
					out.println(textField.getText());
					out.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.appendText(textField.getText());
				textField.clear();
			});
			endBtn.setOnAction(e -> {
				try {
					s.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
		} catch(Exception e) {}	
		
	}
	
}
