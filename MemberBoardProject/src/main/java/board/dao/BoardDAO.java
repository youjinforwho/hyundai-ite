package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import book.vo.BookVO;

public class BoardDAO {

	private SqlSession session;
	public BoardDAO(SqlSession session) {
		this.session = session;
	}
	
	public List<BoardVO> select (BoardVO vo) throws Exception {
		List<BoardVO> result = null;
		result = session.selectList("books.selectByKeyword", vo);
		return result;
	}
}
