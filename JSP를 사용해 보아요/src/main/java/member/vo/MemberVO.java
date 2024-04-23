package member.vo;

public class MemberVO {
	private String userName;
	private String userAge;
	public MemberVO(String userName, String userAge) {
		super();
		this.userName = userName;
		this.userAge = userAge;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	
}
