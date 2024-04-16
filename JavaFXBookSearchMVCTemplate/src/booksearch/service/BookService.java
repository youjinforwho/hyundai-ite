package booksearch.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import booksearch.dao.BookDAO;
import booksearch.vo.BookVO;
import javafx.collections.ObservableList;

public class BookService {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //mysql이 제공해주는 jdbc 풀패키지명 명시
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	//로직 처리를 담당하는 비즈니스 메서드가 나오면 됨
	
	//transaction
	public ObservableList<BookVO> searchBookByKeyword(String keyword) {
		//일반적인 로직처리 코드 수행
		
		//DB처리 -> DAO에게 위임해서 처리 후 결과를 받아옴
		
		//지금은 별다른 로직처리할게 X
		//DAO 만들어서 DB처리 수행 -> 필요할 때마다 new 해서 만드는 습관은 좋지 않음
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "drx2312##");
			conn.setAutoCommit(false);
		} catch(Exception e) {
			
		}
		BookDAO dao = new BookDAO(conn);
		ObservableList<BookVO> result = dao.select(keyword);
		
		//이후 로직처리를 할 게 없기 떄문에 => 결과를 controller에게 그대로 return
		return result;
	}

	public ObservableList<BookVO> deleteSelectedBook(String deleteIsbn, String keyword) {
		//1. 입력으로 들어온 ISBN 번호로 책을 삭제
		//2. 삭제 후 입력으로 들어온 키워드를 이용해서 책을 검색
		//3. 추가로 삭제된 책은 다른 table에 insert해서 로그로 남겨둠
		//작업 3번 하지 말고 dao에 대해 select insert, update로 각각 나눠서 처리하는 것을 지향해야 함
		//dao를 Service처럼 만들면 안됨
		//트랜잭션 처리를 하기 위해서 service 단에서 트랜잭션이 설정된 connection 객체를 생성해서 DAO에 주입해줘야 함
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "drx2312##");
			conn.setAutoCommit(false);
		} catch(Exception e) {
			
		}
		BookDAO dao = new BookDAO(conn);
		//dao.insert(deleteIsbn);
		int count = dao.delete(deleteIsbn);
		ObservableList<BookVO> result = dao.select(keyword);
		
		//최종 결과를 확인
		//만약 문제 없이 각 트랜잭션의 세부 작업이  성공했으면 전체적으로 commit
		//만약 각 작업을 수행할 때 문제가 발생했으면 전체적으로 rollback
		
		try {
			conn.commit();
			conn.rollback();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

}
