package member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	private String member_id;
	private String member_pw;
	private String member_name;
	private int member_age;
	private String member_gender;
}