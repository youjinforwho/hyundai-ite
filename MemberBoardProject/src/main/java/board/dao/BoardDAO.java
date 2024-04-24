package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.BoardVO;

public class BoardDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public BoardDAO(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
	public int insert(BoardVO board, SqlSession session) throws Exception {
		int result = session.insert("board.insertNewBoard", board);
		
		return result;
	}
	public List<BoardVO> select(SqlSession session) throws Exception {
		List<BoardVO> result = session.selectList("board.updateNewBoard");
		return result;
	}
	public BoardVO select(int boardNum, SqlSession session) throws Exception {
		BoardVO result = session.selectOne("board.searchDetailView", boardNum);
		return result;
	}
	public int delete(int boardNum, SqlSession session) throws Exception {
		int result = session.delete("board.deleteBoardContent", boardNum);
		return result;
	}
	public int update(BoardVO board, SqlSession session) {
		int result = 0;
		System.out.println(board.getBoard_content());
		System.out.println(board.getBoard_subject());
		result = session.update("board.updateBoardContent", board);
		return result;
	}
}
