package member.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import member.vo.MemberVO;

public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	public MemberDAO() {
		
	}
	
	public MemberDAO(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public MemberVO select(MemberVO memberInfo, SqlSession session) throws Exception {
		MemberVO result = session.selectOne("member.checkMemberInfo", memberInfo);
		
		return result;
	}

	public int insert(MemberVO memberInfo, SqlSession session) throws Exception {
		int result = session.insert("member.insertMemberInfo", memberInfo);
		
		return result;
	}
}
