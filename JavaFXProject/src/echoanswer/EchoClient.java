package echoanswer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EchoClient extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("echoClient.fxml"));
		
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
