package chapter04;

import chapter04_vo.Personal;
import chapter04_vo.Student;

public class PersonalTest {
	public static void main(String[] args) {
		Student s = new Student();
		s.setSchool("00초등학교");
		s.setGrade(1);
		s.setId(01);
		
		Personal p = new Personal("홍길동", "2000년 01월 01일", s);
		System.out.println(p.toString());
	}
}
