package library.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import library.vo.BookVO;
import library.dao.BookDAO;
import javafx.collections.ObservableList;
import library.mybatis.MyBatisConnectionFactory;

public class BookService {
	//Session 연결하는 부분
	private SqlSessionFactory factory;
	private BookDAO dao;
	
	public BookService() {
		this.factory = MyBatisConnectionFactory.getSqlSessionFactory();
		dao = new BookDAO(factory);
	}
	//Book 조회 메서드
	public List<BookVO> searchBookByKeyword(String keyword) {
		SqlSession session = factory.openSession();
		List<BookVO> result = dao.select(keyword, session);
		return result;
	}
	
	//Book 수정 메서드
	
	//Book 삭제 메서드
//	public List<BookVO> deleteSelectedBook(String keyword) {
//		List<BookVO> result = dao.delete(keyword);
//		return result;
//	}
}
