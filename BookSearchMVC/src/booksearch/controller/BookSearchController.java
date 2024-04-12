package booksearch.controller;

import java.net.URL;
import java.util.ResourceBundle;

import booksearch.VO.BookVO;
import booksearch.service.BookSearchService;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookSearchController implements Initializable {
	@FXML private TextField textField;
	@FXML private Button searchBtn;
	@FXML private Button deleteBtn;
	@FXML private TableView<BookVO> tableView;
	
	@FXML private TableColumn<BookVO, String> isbn;
	@FXML private TableColumn<BookVO, String> title;
	@FXML private TableColumn<BookVO, Integer> price;
	@FXML private TableColumn<BookVO, String> author;
	private BookSearchService service = new BookSearchService();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		isbn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		title.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		price.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		author.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
		searchBtn.setOnAction(e -> {
			//검색 버튼을 눌렀을 때 해야하는 작업
			//실제 로직처리는 Controller가 하지 않음 => 따로 만들어서 사용해야
			//해당 객체를 이용해서 일을 시킴
			String keyword = textField.getText();
			//의미있는 비즈니스 메서드 명을 적어주는 것이 좋음
			ObservableList<BookVO> data = service.searchBookByKeyWord(keyword);
			tableView.setItems(data);
		});
		
		deleteBtn.setOnAction(e -> {
			BookVO selectedItem = tableView.getSelectionModel().getSelectedItem();
			if (selectedItem != null) {
				service.deleteBookByCliked(selectedItem);
			}
			Platform.runLater(() -> {
				tableView.getItems().remove(selectedItem);
			});

		});
	}
}
