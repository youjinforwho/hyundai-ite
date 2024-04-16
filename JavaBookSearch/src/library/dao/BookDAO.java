package library.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javafx.collections.ObservableList;
import library.vo.BookVO;

public class BookDAO {
private SqlSessionFactory sqlSessionFactory;
	
	public BookDAO() {
		
	}
	
	//생성자 주입(Constructor Injection)
	public BookDAO(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public List<BookVO> select(String keyword, SqlSession session) {
		List<BookVO> result = null;
		
		try { 
			result = session.selectList("library.book.selectFromKeywordBookVO", keyword);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}
}
