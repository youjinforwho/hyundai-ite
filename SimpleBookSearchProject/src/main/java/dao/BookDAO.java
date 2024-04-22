package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.BookVO;

public class BookDAO {
private SqlSessionFactory sqlSessionFactory;
	
	public BookDAO() {
		
	}
	
	//생성자 주입(Constructor Injection)
	public BookDAO(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public List<BookVO> select(String keyword, int price, SqlSession session) throws Exception {
		List<BookVO> result = null;
		Map<String, Object> parameters = new HashMap<>();
        parameters.put("keyword", keyword);
        parameters.put("price", price);
        result = session.selectList("book.selectFromKeywordBookVO", parameters);
		return result;
	}

	public int delete(BookVO selectedItem, SqlSession session) {
		String bsibn = selectedItem.getBisbn();
		int result = 0;
		result = session.delete("book.deleteFromKeyword", bsibn);
		return result;
	}

	public int update(BookVO selectedItem, SqlSession session) {
		int result = 0;
		result = session.update("book.titleUpdate", selectedItem);
		return result;
	}
}
