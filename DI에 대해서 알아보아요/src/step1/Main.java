package step1;

public class Main {
	public static void main(String[] args) {
		//사용자 등록
		UserDAO dao = new UserDAO();
		User user = new User("HD", "홍길동", "1234"); //새로운 사용자 생성
		try {
			int result = dao.insert(user);
			if (result != 1) {
				throw new Exception();
			}
			System.out.println("사용자 등록 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//사용자 검색
		try {
			User user2 = dao.select("HGD");
			System.out.println(user2.getName());
		} catch (Exception e) {
			
		}
	}
}
