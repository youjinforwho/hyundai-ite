package booksearch.controller;

import java.net.URL;
import java.util.ResourceBundle;

import booksearch.service.BookService;
import booksearch.vo.BookVO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookSearchController implements Initializable {
	@FXML private TextField textField;
	@FXML private Button searchBtn;
	@FXML private Button deleteBtn;
	@FXML private TableView tableView;
	@FXML private TableColumn<BookVO, String> isbn; //S(arg1): 어떤 VO를 이용해서 컬럼에 매핑시킬 건지, V(arg2): 그에 대한 데이터 타입을 지칭
	@FXML private TableColumn<BookVO, String> title;
	@FXML private TableColumn<BookVO, Integer> price;
	@FXML private TableColumn<BookVO, String> author;
	
	private String deleteIsbn; //삭제할 책의 고유번호
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		isbn.setCellValueFactory(new PropertyValueFactory<>("bisbn")); //VO의 어떤 필드를 가지고 해당 컬럼을 setting할지 명시 해주면 됨
		title.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		price.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		author.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
		
		//각각의 row에 대한 처리를 하고 싶을 때
		tableView.setRowFactory(e -> {
			TableRow<BookVO> row = new TableRow<BookVO>();
			
			row.setOnMouseClicked(e1 -> {
				if(e1.getClickCount()== 1 && !row.isEmpty()) {
					BookVO book = row.getItem(); //각 행은 VO로 만든것이므로 바로 가져올 수 있음
					deleteIsbn = book.getBisbn();
				}
			});
			
			return row;
		});
		
		searchBtn.setOnAction(e -> {
			//controller에서는 로직처리를 하지 않음
			//로직 처리 하는 객체를 이용해 일을 시킴(method 호출)
			BookService service = new BookService(); //버튼을 만들때마다 객체가 만들어지는 것은 낭비!!
			//처리된 결과를 받아 화면 제어를 수행
			ObservableList<BookVO> list = service.searchBookByKeyword(textField.getText());
			tableView.setItems(list); //받아온 VO의 데이터를 화면에 테이블 형태로 출력
		});
		
		deleteBtn.setOnAction(e -> {
			BookService service = new BookService();
			ObservableList<BookVO> list = service.deleteSelectedBook(deleteIsbn, textField.getText());
			tableView.setItems(list);
		});
	}
	
}
