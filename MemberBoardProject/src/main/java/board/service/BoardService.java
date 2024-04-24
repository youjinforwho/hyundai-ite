package board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.dao.BoardDAO;
import board.vo.BoardVO;
import mybatis.MyBatisConnectionFactory;

//transaction을 생각해요 해요!
public class BoardService {
	private SqlSessionFactory factory;
	private BoardDAO dao;
	
	public BoardService() {
		this.factory = MyBatisConnectionFactory.getSqlSessionFactory();
		dao = new BoardDAO(factory);
	}

	public int createNewBoard(BoardVO board) {
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = dao.insert(board, session);
		} catch(Exception e) {
			System.out.println("에러");
			System.out.println(e);
			session.rollback();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}

	public List<BoardVO> updateBoardList() {
		SqlSession session = factory.openSession();
		List<BoardVO> result = null;
		
		try {
			result = dao.select(session);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}

	public BoardVO viewBoardDetail(int boardNum) {
		SqlSession session = factory.openSession();
		BoardVO result = null;
		try {
			result = dao.select(boardNum, session);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}

	public int deleteBoardContent(int boardNum) {
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = dao.delete(boardNum, session);
		} catch (Exception e) {
			System.out.println(e);
			session.rollback();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}

	public int updateBoardContent(BoardVO boardDetail) {
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = dao.update(boardDetail, session);
		} catch (Exception e) {
			System.out.println(e);
			session.rollback();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}
	

}
