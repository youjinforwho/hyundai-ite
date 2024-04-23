package member.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import member.dao.MemberDAO;
import member.vo.MemberVO;
import mybatis.MyBatisConnectionFactory;

public class MemberLoginService {
	private SqlSessionFactory factory;
	private MemberDAO dao;
	
	public MemberLoginService() {
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
}
