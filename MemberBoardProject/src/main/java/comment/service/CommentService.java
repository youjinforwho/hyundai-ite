package comment.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import comment.dao.CommentDAO;
import comment.vo.CommentVO;
import mybatis.MyBatisConnectionFactory;

public class CommentService {
	private SqlSessionFactory factory;
	private CommentDAO dao;
	
	public CommentService() {
		this.factory = MyBatisConnectionFactory.getSqlSessionFactory();
		dao = new CommentDAO();
	}
	
	public List<CommentVO> findAllComments(int boardNum) {
		SqlSession session = factory.openSession();
		List<CommentVO> result = null;
		
		try {
			result = dao.select(boardNum, session);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}

	public int createNewComment(CommentVO comment) {
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = dao.insert(comment, session);
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

	public CommentVO viewCommentDetail(int commentNum) {
		SqlSession session = factory.openSession();
		CommentVO result = null;
		try {
			result = dao.selectone(commentNum, session);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}

	public int updateCommentContent(CommentVO updateComment) {
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = dao.update(updateComment, session);
		} catch (Exception e) {
			System.out.println(e);
			session.rollback();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}

	public int deleteCommentContent(int commentNum) {
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = dao.delete(commentNum, session);
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
