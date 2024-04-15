package step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	//User table에 대한 데이터베이스 처리를 담당하는 class(DAO)
	
	//사용자 입력(추가)
	public int insert(User user) throws Exception { //throw문을 사용하면 해당 메서드를 호출한 곳으로 예외 넘김 -> 한군데서 모아서 처리할 때 사용
		//6단계의 DB 처리 코드 작성
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "drx2312##");
		String sql = "INSERT INTO user VALUES(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		//insert, update, delete에는 update메서드 사용 (select 계열은 executeQuery())
		//리턴값은 영향을 받은 행의 개수
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}
	
	
	
	//사용자 검색
	public User select(String userId) throws Exception {
		//6단계의 DB 처리 코드 작성
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "drx2312##");
		String sql = "SELECT * FROM user WHERE id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		//insert, update, delete에는 update메서드 사용 (select 계열은 executeQuery())
		//리턴값은 영향을 받은 행의 개수
		ResultSet rs = pstmt.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User(rs.getString("id"), 
					rs.getString("name"), 
					rs.getString("password"));
		}
		pstmt.close();
		conn.close();
		
		return user;
	}
}