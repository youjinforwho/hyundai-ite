package booksearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import booksearch.VO.BookVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookDAO {
	//비즈니스같은 이름의 메서드를 쓰면 안됨
	private Connection conn;
	
	public BookDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "drx2312##");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	public ObservableList<BookVO> select(String keyword) {
		ObservableList<BookVO> data = FXCollections.observableArrayList();
		String sql = "select bisbn, btitle, bprice, bauthor from book where btitle LIKE ?";
		
		try {
			//IN Parameter를 채워서 실행해야 함
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery(); //rs는 결과 레코드 집합의 포인터 
			
			while (rs.next()) {
				//실제 데이터 리스트 안에 추가
				BookVO book = new BookVO(rs.getString("bisbn"),
					rs.getString("btitle"),
					rs.getInt("bprice"),
					rs.getString("bauthor"));
				
				data.add(book);
			}
			
		} catch (Exception e1) {
			
		}
		//데이터는 Service -> Controller로 넘겨짐
		return data;
	}
	public void delete(BookVO selectedItem) {
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
		
	}

}
