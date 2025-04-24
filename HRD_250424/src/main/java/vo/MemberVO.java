package vo;

import lombok.Data;

@Data
public class MemberVO {
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private String joindate;
	private String grade;
	private String city;
}
