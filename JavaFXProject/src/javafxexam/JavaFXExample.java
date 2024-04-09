package javafxexam;

import java.util.Stack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXExample extends Application {
	
	@Override //창의 기본 형태인 start 메서드를 오버라이딩 시켜서 상속
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성
		
		//1. pane이라고 표현되는 layout 만들기(판떼기 객체)
		//여러 종류의 pane이 있는데 그 중 하나를 이용
		//pane 종류마다 버튼같은 component를 배치시키는 방법이 다름
		StackPane root = new StackPane();
		
		//2. 화면에 보여줄 요소 생성
		Button btn = new Button();
		btn.setText("클릭해주세요");
		//버튼이 클릭되면 무슨일을 할지 코드로 작성해야 함
		//자바의 event model은 delegation model을 이용함
		//이벤트처리를 위임한다는 의미로 delegation라는 표현 이용
		//버튼 클릭시 버튼이 event source가 됨
		//event source는 이벤트가 발생한 객체를 지칭 => 버튼
		//이벤트가 발생했을 때 이벤트의 처리(로직수행)를 event source가 직접 처리하지 않고 
		//별도의 객체를 이용하게 됨(=리스너 객체)
		//해당 객체 안에는 이벤트를 처리하는 method가 있음(handler)
		//마지막으로 event source에 listener를 부착시키는 과정이 필요
		//Action이라는 event 사용 => 마우스 클릭, 입력상자에서 Enter 키 입력을 지칭하는 event
		
		//버튼(event source)에서 Action Event가 발생했을 때 처리하는 Event Handler 객체를 만들어서 이벤트 처리를 함
		//리스너 객체 생성 후 버튼에 붙이기
		//리스너 객체도 어떤 이벤트를 처리하느냐에 따라 종류가 다름 
		
//		btn.setOnAction(new EventHandler<ActionEvent>() {
//			//이벤트 처리 작성
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("너무 힘들어요");
//			}
//		});
		
		//람다를 이용한 축약(안에서 오버라이딩 해야할 함수가 하나밖에 없기 때문에 가능)
		btn.setOnAction((e) -> {
				System.out.println("너무 힘들어요");
			}
		);
		
		//3. Pane 위에 표현할 Component 위치시키기
		root.getChildren().add(btn);
		
		//4. Scene 생성
		Scene scene = new Scene(root, 300, 250); //창으로 할 대상과 윈도우의 크기 설정

		//5. Stage(start의 인자)에 Scene 설정하기
		primaryStage.setTitle("첫 화면입니다");
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		//Application이 갖고 있는 static 메서드 -> 내부적으로 start라는 메서드가 호출되면서 창이 뜸
		launch(args);
	}
}
