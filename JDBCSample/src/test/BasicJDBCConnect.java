package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 0. 당연히 DBMS가 제공하는 JDBC Driver class를 우리가 사용할 수 있어야 함 -> Driver를 설치했으므로
// 해당 class를 다운로드 받아서 이걸 우리 프로젝트에 Build Path에 포함시켜야 함
public class BasicJDBCConnect {
	
	public static void main(String[] args) {
		try {
			//1. 우리는 MySQL에 연결할 거에요. 그러면 당연히 MySQL에 연결하기 위한 JDBC Driver를 프로그램 안으로 로딩해야 함
			//드라이버 로딩 -> 2가지 방법이 있음: Register메서드, Class.forName()
			Class.forName("com.mysql.cj.jdbc.Driver");//풀패키지명 작성
			System.out.println("드라이버 로딩 성공성공");
			//2. 실제 데이터베이스에 접속(Connection을 연다)
			//접속하려면 3가지 정보가 있어야 함
			// - 데이터베이스에 계정 Id와 Pw가 있어야 함
			//접속하려는 데이터베이스에 대한 URL이 있어야 함 => JDBC url
			String myId = "root";
			String myPw = "drx2312##";
			String JDBC_URL = "jdbc:mysql://localhost:3306/employees?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"; //(프로토콜 - jdbc:mysql + ip주소 + port 번호) + 관련 정보(DB이름) 
			Connection conn = DriverManager.getConnection(JDBC_URL, myId, myPw);
			System.out.println("데이터베이스 접속 성공성공");
			
			//3. Connection 객체를 얻었으면 이제 SQL 쿼리를 작성해서 전달해야 하는데
			//이 SQL을 실어서 보낼 객체가 하나 필요함 => Statement
			//이 Statement는 크게 3가지 종류가 존재 (어느정도 외우는게 좋음)
			//1. 제일 간단한 형태인 Statement
			//2. 조금 더 나은 형태의 preparedStatement => 기본보다 효율이 좋기 때문에 이걸 사용할 거에요
				//-> 이 statement는 SQL Query를 갖고 있는 Statement
			//3. Stored Procedure를 호출할 수 있는 CallableStatement => 아예 다른 용도로 사용됨
			String sql = "select * from employees where gender='F'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 이렇게 전달할 Statement를 만들었으면 이제 실행하면 돼요 => SQL Query를 실행할 수 있어요
			//그런데 실행하려는 SQL이 만약 SELECT 계열이면 => 결과레코드 집합을 반환해요
			//이때 사용하는 method는 executeQuery()를 이용해요
			//그러면 이때 return 값은 어떻게 받으면 되나요? => ResultSet이라는 포인터(?)로 받아요
			ResultSet rs = pstmt.executeQuery();
			
			//5. ResultSet을 이용해서 데이터 추출(로직처리)
			rs.next();
			//현재 rs의 위치에서 문자열 형태로 갖고오기
			String firstName = rs.getString("first_name"); 
			System.out.println(firstName);
			rs.next();
			firstName = rs.getString("first_name"); 
			System.out.println(firstName);
			
			//6. 사용된 자원의 반납 => 사용한 여러 자원들을 close 시켜서 정상 종료를 해줘야 함
			//자바 프로그램에서 데이터베이스에 연결하는 것이기 때문에 정상적으로 프로그램을 종료시켜야 데이터 쪽에서 문제가 생기지 않음(리소스 낭비 우려)
			//사용한 자원들을 생성과 반대 순서로 close처리 해줘야 함
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("뭔가 잘못되었어요");
		} 
	} 
}
