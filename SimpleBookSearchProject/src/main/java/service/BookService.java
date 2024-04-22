package service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.BookVO;
import dao.BookDAO;
import mybatis.MyBatisConnectionFactory;

public class BookService {
	//Session 연결하는 부분
	private SqlSessionFactory factory;
	private BookDAO dao;
	
	public BookService() {
		this.factory = MyBatisConnectionFactory.getSqlSessionFactory();
		dao = new BookDAO(factory);
	}
	//Book 조회 메서드
	public List<BookVO> searchBookByKeyword(String keyword, int price) {
		SqlSession session = factory.openSession();
		List<BookVO> result = null;
		try {
			result = dao.select(keyword, price, session);
		} catch(Exception e) {
			session.rollback();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}
	
	//Book 삭제 메서드
	public int deleteBookByCliked(BookVO selectedItem) {
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = dao.delete(selectedItem, session);
		} catch(Exception e) {
			session.rollback();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}
	
	//Book 수정 메서드
	public int updateBookByTitle(BookVO selectedItem) {
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = dao.update(selectedItem, session);
		} catch(Exception e) {
			session.rollback();
		} finally {
			session.commit();
			session.close();
		}
		return result;
	}
	
}
