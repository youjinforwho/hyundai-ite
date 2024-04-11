package echoanswer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//창으로 만들기 위해 Application을 상속 받아 구현
//모듈 사용을 명시하기 위해 RunConfiguration에 인자를 넣어줘야 함
public class EchoServer extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성을 하면 돼요!
		// 이미 SceneBuilder를 이용해서 화면구성에 대한 FXML 파일을 만들어놨어요
		// 해당 파일을 이용해서 Pane을 가져와서 Scene을 만들고 Stage에 붙여서 사용하면 될거 같아요
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("echoServer.fxml"));
		
		try {
			root = loader.load();
		} catch(Exception e) {
			System.err.println(e); //원래는 예외에 대한 처리가 필요함
		}
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
