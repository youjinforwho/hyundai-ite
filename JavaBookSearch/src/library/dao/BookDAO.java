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
	
	public List<BookVO> select(String keyword, SqlSession session) throws Exception {
		List<BookVO> result = null;		 
		result = session.selectList("library.book.selectFromKeywordBookVO", keyword);

		return result;
	}

	public int delete(BookVO selectedItem, SqlSession session) {
		String bsibn = selectedItem.getBisbn();
		int result = 0;
		result = session.delete("library.book.deleteFromKeyword", bsibn);
		return result;
	}

	public int update(BookVO selectedItem, SqlSession session) {
		int result = 0;
		result = session.update("library.book.titleUpdate", selectedItem);
		return result;
	}
}
