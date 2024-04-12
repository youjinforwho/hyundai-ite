package test;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import test.vo.BookVO;

public class BookSearchController implements Initializable {
	@FXML private Button searchBtn;
	@FXML private TextField textField;
	@FXML private TextArea searchArea;
	private Connection conn;
	
	public BookSearchController() {
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
				while (rs.next()) {
					BookVO book = new BookVO(rs.getString("bisbn"),
						rs.getString("btitle"),
						rs.getInt("bprice"),
						rs.getString("bauthor"));

					//내부적으로 스레드를 하나 만들어서 내가 갖고 있는 txt를 그대로 포함해서 동작하도록
					Platform.runLater(() -> {
						searchArea.appendText(book.toString()+"\n");
					});
				}
			} catch (Exception e1) {
				
			}
		});
		
	}
}
