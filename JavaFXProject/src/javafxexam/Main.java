package javafxexam;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application { //Application은 추상클래스
	
	Button btn; //import할때 주의
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//여기부터 시작됨
		//FXML을 이용하는 것이 아니라, 코드로 화면 구성
		//1. Pane이 필요
		//BorderPane 사용 => 화면을 5개의 영역(동, 서, 남, 북, 중앙)으로 분할
		//method를 통해서 UI의 위치 지정
		BorderPane root = new BorderPane();
		root.setPrefSize(300, 300); //크기 지정
		
		//2. 이 Pane에 필요한 UI 요소들(버튼 등)을 배치시킴 --> FXML사용
		btn = new Button("새로운 창을 띄워보아요");
		btn.setPrefSize(300, 50); //버튼의 가로세로 길이 지정
		btn.setOnAction(e -> { //람다식을 이용한 처리
			//버튼을 누르면 새 창(새 스테이지)을 띄울 수 있도록 처리
			MyStage stage = new MyStage();
			stage.show();
		});
		root.setBottom(btn); //버튼을 화면에 부착
		//3. 이렇게 만든 Pane을 이용해서 Scene 생성
		Scene scene = new Scene(root);
		//4. Stage에 Scene 부착
		primaryStage.setScene(scene);
		//5. Stage를 show
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
