package chapter04;

import chapter04_vo.User;

public class UserTest {

	public static void main(String[] args) {
		User user = new User();
		
		user.setNo(101);
		user.setName("홍길동");
		user.setGender("MALE");
		
		user.pay(20000);
	}

}
