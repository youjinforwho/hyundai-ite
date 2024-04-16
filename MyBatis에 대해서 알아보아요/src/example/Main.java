package example;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import example.dao.BookDAO;
import example.mybatis.MyBatisConnectionFactory;
import example.vo.BookVO;

public class Main {
	public static void main(String[] args) {
		//데이터베이스 처리
		//DAO가 있어야 DB처리를 할 수 있음
		//SqlSessionFactory를 먼저 확보해야
		//확보한 객체를 주입해서 DAO를 만듦
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
		
		BookDAO dao = new BookDAO(factory);
//		HashMap<String, Object> result = dao.selectByISBNHashMap("89-7914-206-4");
//		for (String key: result.keySet()) {
//			System.out.println(key + " : " + result.get(key));
//		}
		//2. 모든 책에 대한 정보를 HashMap으로 변환해서 가져올 거에요!
//		List<HashMap<String, Object>> result = dao.selectAllHashMap();
//		for(HashMap<String, Object> map: result) {
//			for (String key: map.keySet()) {
//				System.out.println(key+" : " + map.get(key));
//			}
//			System.out.println();
//		}
		
		//3. ISBN번호를 이용해서 책 1권의 정보를 BookVO로 변환해서 가져오기
//		BookVO result = dao.selectByISBNBookVO("89-7914-206-4");
//		System.out.println(result);
		
		//4. ISVN번호를 이용해서 책 1권의 정보를 BookVO로 변환해서 가져오기
		//table의 column 명이 VO와 다른 
//		BookVO result = dao.selectByISBNResultMap("89-7914-206-4");
//		System.out.println(result);
		
		//5. ISBN번호를 이용해서 책 1권의 정보를 변경하고 싶어요
		//책의 제목을 어떻게 변경해야 하나요?
		BookVO bookVO = new BookVO("89-7914-206-4", "소리없는 아우성", 0, null);
		int result = dao.titleUpdate(bookVO);
		System.out.println("영향을 받은 행의 개수는 " + result);
	}
}
