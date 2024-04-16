package example.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	//실제 프로그램(DAO)에서 사용하는 데이터베이스 연결 객체는
	//기존에는 (JDBC)일 때는 Connection 객체를 이용했어요
	//MyBatis에서는 SqlSession이라는 객체를 이용
	private static SqlSessionFactory sqlSessionFactory;
	
	//이 Factory 객체는 해당 클래스로부터 1개만 만들어져서 사용되도록 처리(Singleton)
	static {
		try {
			String resource = "./SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			
			if (sqlSessionFactory == null) {
				//엄연히 말하면 싱글톤은 아님
				//의미상 싱글톤이라고 할 수 있음
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
