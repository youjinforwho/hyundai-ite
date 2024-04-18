package library.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import library.service.BookService;
import library.vo.BookVO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class BookController implements Initializable {
	@FXML private TextField textField;
	@FXML private TextField textFidld1;
	@FXML private Button updateBtn;
	@FXML private Button searchBtn;
	@FXML private Button deleteBtn;
	@FXML private TableView<BookVO> tableView;
	
	@FXML private TableColumn<BookVO, String> isbn; //S(arg1): 어떤 VO를 이용해서 컬럼에 매핑시킬 건지, V(arg2): 그에 대한 데이터 타입을 지칭
	@FXML private TableColumn<BookVO, String> title;
	@FXML private TableColumn<BookVO, Integer> price;
	@FXML private TableColumn<BookVO, String> author;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		isbn.setCellValueFactory(new PropertyValueFactory<>("bisbn")); //VO의 어떤 필드를 가지고 해당 컬럼을 setting할지 명시 해주면 됨
		title.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		price.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		author.setCellValueFactory(new PropertyValueFactory<>("bauthor"));

		tableView.setEditable(true);
        title.setCellFactory(TextFieldTableCell.forTableColumn());

	    title.setOnEditCommit(event -> {
	        // 변경된 값 가져오기
	        BookService service = new BookService();
	        BookVO selectedItem = event.getRowValue();
	        selectedItem.setBtitle(event.getNewValue());
	        int result = service.updateBookByTitle(selectedItem);
	        System.out.println(result);
	        if (result != 0) System.out.println("성공적으로 수정되었습니다.");
	        Platform.runLater(() -> {
	        	// 변경된 값으로 데이터 모델 업데이트
	        	event.getTableView().getItems().get(event.getTablePosition().getRow()).setBtitle(selectedItem.getBtitle());
			});
	 
	    });


		searchBtn.setOnAction(e -> {
			//controller에서는 로직처리를 하지 않음
			//로직 처리 하는 객체를 이용해 일을 시킴(method 호출)
			BookService service = new BookService(); //버튼을 만들때마다 객체가 만들어지는 것은 낭비!!
			//처리된 결과를 받아 화면 제어를 수행
			ObservableList<BookVO> list = FXCollections.observableList(service.searchBookByKeyword(textField.getText()));
			tableView.setItems(list); //받아온 VO의 데이터를 화면에 테이블 형태로 출력
		});
		
		deleteBtn.setOnAction(e -> {
			BookVO selectedItem = tableView.getSelectionModel().getSelectedItem();
			int result = 0;
			BookService service = new BookService();
			if (selectedItem != null) {
				result = service.deleteBookByCliked(selectedItem);
			}
			if (result != 0) System.out.println(result + "개 데이터가 성공적으로 삭제 되었습니다.");
			Platform.runLater(() -> {
				tableView.getItems().remove(selectedItem);
			});
		});
	
	}
}
