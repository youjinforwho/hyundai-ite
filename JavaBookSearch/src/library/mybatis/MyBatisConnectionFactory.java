package library.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
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
