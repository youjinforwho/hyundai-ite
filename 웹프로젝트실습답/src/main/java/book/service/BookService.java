package book.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import book.dao.BookDAO;
import book.vo.BookVO;
import mybatis.MyBatisConnectionFactory;

//transaction을 생각해요 해요!
public class BookService {

	public List<BookVO> getBooksByKeyword(BookVO vo) {
		//로직처리와 Database 처리를 하면 되는데
		//Database처리는 당연히 DAO에게 위임해야 되고
		//transaction 때문에 SqlSession 객체를 DAO에게 injection해서 사용해야 함
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory(); //session을 뽑아낼 수 있는 공장 객체 get
		SqlSession session = factory.openSession();
		List<BookVO> result = null;
		
		//DAO를 이용해서 DB처리를 하면 됨
		//DB transaction도 여기서 처리하면 돼요
		//commit, rollback service를 해야 함
		try {
			BookDAO dao = new BookDAO(session);
			result = dao.select(vo);
		} catch(Exception e) {
			
		} finally {
			session.close();
		}
		return result;
	}

}
