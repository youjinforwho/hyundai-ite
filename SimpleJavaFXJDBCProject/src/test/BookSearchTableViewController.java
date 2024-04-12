package test;

import java.awt.print.Printable;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import test.vo.BookVO;

public class BookSearchTableViewController implements Initializable {
	@FXML private Button searchBtn;
	@FXML private Button deleteBtn;
	@FXML private TextField textField;
	@FXML private TableView<BookVO> tableView;
	
	@FXML private TableColumn<BookVO, String> isbnCol;
	@FXML private TableColumn<BookVO, String> titleCol;
	@FXML private TableColumn<BookVO, Integer> priceCol;
	@FXML private TableColumn<BookVO, String> authorCol;
	
	private Connection conn;
	
	public BookSearchTableViewController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "drx2312##");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		searchBtn.setOnAction(e -> {
			String keyword = textField.getText();
			
			//IN Parameter를 이용해서 PreparedStatement를 생성해요!
			String sql = "select bisbn, btitle, bprice, bauthor from book where btitle LIKE ?";
			try {
				//IN Parameter를 채워서 실행해야 함
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + keyword + "%");
				ResultSet rs = pstmt.executeQuery(); //rs는 결과 레코드 집합의 포인터 
				ObservableList<BookVO> data = FXCollections.observableArrayList();
			
				isbnCol.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
				titleCol.setCellValueFactory(new PropertyValueFactory<>("btitle"));
				priceCol.setCellValueFactory(new PropertyValueFactory<>("bprice"));
				authorCol.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
				
				while (rs.next()) {
					//실제 데이터 리스트 안에 추가
					BookVO book = new BookVO(rs.getString("bisbn"),
						rs.getString("btitle"),
						rs.getInt("bprice"),
						rs.getString("bauthor"));
					
					//내부적으로 스레드를 하나 만들어서 내가 갖고 있는 txt를 그대로 포함해서 동작하도록
//					Platform.runLater(() -> {
//						searchArea.appendText(book.toString()+"\n");
//					});
					data.add(book);
				}
				//VO가 갖고 있는 특정 프로퍼티 매칭 시켜줘야 함 
				//내가 만든 테이블 뷰에 데이터 추가
				tableView.setItems(data);
			} catch (Exception e1) {
				
			}
		});
		deleteBtn.setOnAction(e -> {
			BookVO selectedItem = tableView.getSelectionModel().getSelectedItem();
			if (selectedItem != null) {
				try {
				String title = selectedItem.getBtitle();
				System.out.println(title);
				String sql = "delete from book where btitle = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.executeUpdate(); //rs는 결과 레코드 집합의 포인터
				} catch(Exception e1) {
					System.out.println(e1);
				}
				tableView.getItems().remove(selectedItem);
				
			}
		});
		
	}

}
