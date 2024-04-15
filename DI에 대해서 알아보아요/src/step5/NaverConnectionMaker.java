package step5;

import java.sql.Connection;
import java.sql.DriverManager;

public class NaverConnectionMaker implements ConnectionMaker {

	@Override
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "drx2312##");
		return conn;
	}

}
