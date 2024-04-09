package javafxexam;

import java.io.IOException;

import javax.xml.parsers.FactoryConfigurationError;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyStage extends Stage {
	public MyStage() {
		//Pane안에 여러개의 UI Component를 배치
		//당연히 여기에도 Pane이 있어야 -> FXML에서 가져오기
		//FXML 파일을 읽어들이는 과정에서 initialize가 수행되며 자동적으로 Controller 객체가 생성됨
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("example.fxml"));
		try {
			root = loader.load();
		} catch(Exception e) {
			
		}
		//이런 Pane을 갖고 Scene을 생성
		Scene scene = new Scene(root);
		
		//이 Scene을 Stage에 부착
		this.setScene(scene);
	}
}
