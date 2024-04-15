package step4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//다른 사람에게 제공하기 위해(판매자의 입장) userDAO와 VO를 만들어 판매
//제공받은 사람은 추상 클래스를 구현하여 사용
public class UserDAO {
	
	//최대한 상속받지 않기 위해 => 별도의 클래스를(DB 연결하는 부분) 만들어서 제공하는 방법 사용
	private SimpleConnectionMaker simpleConnectionMaker;
	
	public UserDAO() {
		//객체 만들어서 자기 필드에 박음
		simpleConnectionMaker = new SimpleConnectionMaker();
	}
	
	//사용자 입력(추가)
	public int insert(User user) throws Exception { //throw문을 사용하면 해당 메서드를 호출한 곳으로 예외 넘김 -> 한군데서 모아서 처리할 때 사용
		//6단계의 DB 처리 코드 작성
		Connection conn = simpleConnectionMaker.getConnection();
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
		Connection conn = simpleConnectionMaker.getConnection();
		
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