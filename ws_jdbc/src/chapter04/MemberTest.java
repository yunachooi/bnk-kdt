package chapter04;

enum Gender{
	MALE, FEMALE
}

public class MemberTest {
	 public static void main(String[] args) {
		String name = "홍길동";
		Gender gender = Gender.MALE;
		
		System.out.println("회원정보");
		switch(gender) {
		case MALE -> System.out.println("회원 이름 >> " + name + "\n회원 성별 >> 남성");
		case FEMALE -> System.out.println("회원 이름 >> " + name + "\n회원 성별 >> 여성");
		}
	}
}
