package step4;

import java.sql.Connection;
import java.sql.DriverManager;

public class SimpleConnectionMaker {
	public Connection getConnection() throws Exception {
		//해당 구매자가 사용하는 DBMS를 이용해서 DB Connection을 얻는 코드를 작성
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "drx2312##");
		return conn;
	}
}
