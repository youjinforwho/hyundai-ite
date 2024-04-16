package booksearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import booksearch.vo.BookVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//1. Driver Loading (1번만 하면 됨 -> 생성자에 넣기)
//2. Connection 획득
//3. Statement 생성(SQL Query 작성)
//4. 실행 후 결과 가져오기
//5. 결과 처리
//6. 자원 반납(close 처리)

public class BookDAO {
	private Connection conn;
	
	public BookDAO(Connection conn) {
		this.conn = conn;
	}
	//database 처리하는 단일 sql이 나오게 됨
	//여러 개의 오버로딩을 통해 CRUD만 구현, 메서드 이름 역시 기능 그대로 명시(select, delete, update)
	public ObservableList<BookVO> select(String keyword) {
		//Connection 가져오기
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ObservableList<BookVO> result = FXCollections.observableArrayList();
		try {
			//이 connection을 얻어오는 작업은 상당히 load를 많이 잡음 
			
			//거의 예외없이 PreparedStatement를 이용함
			//PreparedStatement는 SQL를 가지고 statement를 생성하는 것을 말함
			String sql = "SELECT bisbn, btitle, bprice, bauthor FROM book WHERE btitle LIKE ?"; //일반 Statement는 '?'(Inparameter) 사용불가
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookVO book = new BookVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getInt("bprice"), rs.getString("bauthor"));
				result.add(book);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			//예외 발생 여부와 상관없이 무조건 자원 해제를 해줘야 하므로
			try {
				rs.close();
				pstmt.close();
				//conn.close(); 연결은 Service에서 끊어줘야 함
			} catch (SQLException e) {
				System.out.println(e);
			}
			
		}
		return result;
	}
	public int delete(String deleteIsbn) {
		//Connection 가져오기
		//Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			//이 connection을 얻어오는 작업은 상당히 load를 많이 잡음 
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "drx2312##");
			//하나의 transaction이 시작됨
			
			
			//거의 예외없이 PreparedStatement를 이용함
			//PreparedStatement는 SQL를 가지고 statement를 생성하는 것을 말함
			String sql = "DELETE FROM book WHERE bisbn = ?"; //일반 Statement는 '?'(Inparameter) 사용불가
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deleteIsbn);
			count = pstmt.executeUpdate();
			//하나의 SQL 구문이 실행되었기 때문에 트랜잭션이 종료됨
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			//예외 발생 여부와 상관없이 무조건 자원 해제를 해줘야 하므로
			try {
				pstmt.close();
				//conn.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
			
		}
		
		return count;
	}
}
