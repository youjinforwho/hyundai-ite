package book.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import book.vo.BookVO;

public class BookDAO {

	private SqlSession session;
	public BookDAO(SqlSession session) {
		this.session = session;
	}
	
	public List<BookVO> select (BookVO vo) throws Exception {
		List<BookVO> result = null;
		result = session.selectList("books.selectByKeyword", vo);
		return result;
	}
}
