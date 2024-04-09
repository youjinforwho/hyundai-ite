package javafxexam;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

//이 class는 FXML 파일에 대한 Evenet 처리를 하는 코드가 담긴 class
//그래서 일반적인 형태의 class가 아니라 특별한 interface(Initializable)를 반드시 구현해야 함
public class MyController implements Initializable {
	@FXML private Button firstBtn;
	
	@FXML
	private Button secondBtn;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//여기에 event처리코드가 나옴
		//객체 생성시 자동으로 initialize()가 호출됨
		System.out.println("Controller 객체가 생성되었어요");
	
		//이벤트 처리코드 작성
		//버튼이 클릭됐을 때 어떤일을 할지 지정하면 됨
		//버튼에 대한 reference가 있어야 함 -> XML에 들어가 해당 버튼에 id 붙여주기
		firstBtn.setOnAction(e -> {
			System.out.println("첫번째 버튼 클릭");
		});
		secondBtn.setOnAction(e -> {
			System.out.println("두번째 버튼 클릭");
		});
	}
	
}
