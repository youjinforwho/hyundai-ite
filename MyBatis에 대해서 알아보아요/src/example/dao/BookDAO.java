package example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import example.vo.BookVO;

public class BookDAO {
	//여기에서 SqlSessionFactory를 직접 얻어내지 X
	//생성자를 통해서 주입받아 사용
	private SqlSessionFactory sqlSessionFactory;
	
	public BookDAO() {
		
	}
	
	//생성자 주입(Constructor Injection)
	public BookDAO(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	//1. ISBN 번호를 입력으로 받아 책 1권의 데이터를 HashMap으로 만들어서 리턴하는 메서드 작성
	//HashMap 이름은 xml에서 명시한 이름과 똑같을 필요 없음
	public HashMap<String, Object> selectByISBNHashMap(String bisbn) {
		HashMap<String, Object> result = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		try { 
			result = session.selectOne("example.mybook.selectByISBNHashMap", bisbn);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}
	
	//2. 모든 책의 데이터를 HashMap의 List로 만들어서 리턴하는 메서드를 작성해보아요
	public List<HashMap<String, Object>> selectAllHashMap() {
		List<HashMap<String, Object>> result = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		try { 
			result = session.selectList("example.mybook.selectAllHashMap");
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}
	
	//3. ISBN번호를 입력으로 받아 책 1권의 데이터를 BookVO로 만들어 리턴하는 메서드 작성
	//1의 HashMap -> VO로 바꾸기
	public BookVO selectByISBNBookVO(String bisbn) {
		
		BookVO result = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		try { 
			result = session.selectOne("example.mybook.selectByISBNBookVO", bisbn);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}
	
	//4. ISBN번호를 이용해서 책 1권의 정보를 BookVO로 변환해서 가져오기
	public BookVO selectByISBNResultMap(String bisbn) {
		
		BookVO result = null;
		SqlSession session = sqlSessionFactory.openSession();
		
		try { 
			result = session.selectOne("example.mybook.selectByISBNResultMap", bisbn);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}
	
	//5. ISBN번호를 이용해서 책 1권의 정보를 변경하기
	public int titleUpdate(BookVO bookVO) {
		int result = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try { 
			result = session.update("example.mybook.titleUpdate", bookVO);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			session.commit(); //update 계열은 반드시 처리해 주어야 함
			session.close();
		}
		return result;

	}
}
