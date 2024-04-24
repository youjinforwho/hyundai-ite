package member.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import member.dao.MemberDAO;
import member.vo.MemberVO;
import mybatis.MyBatisConnectionFactory;

public class MemberService {
	private SqlSessionFactory factory;
	private MemberDAO dao;
	
	public MemberService() {
		this.factory = MyBatisConnectionFactory.getSqlSessionFactory();
		dao = new MemberDAO(factory);
	}
	
	public MemberVO checkPasswordIsTrue(MemberVO memberInfo) {
		SqlSession session = factory.openSession();
		MemberVO result = null;
		try {
			result = dao.select(memberInfo, session);
		} catch(Exception e) {
			
		} finally {
			session.close();
		}
		return result;
	}
	
	public int assignUserToMember(MemberVO memberInfo) {
		SqlSession session = factory.openSession();
		int result = 0;
		try {
			result = dao.insert(memberInfo, session);
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
}
