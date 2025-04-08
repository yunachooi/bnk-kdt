package chapter06;

import java.util.ArrayList;

import chapter06_vo.Student;

public class StudentTest {

	public static void main(String[] args) {
		Student s1 = new Student("James", 93);
		Student s2 = new Student("Ann", 46);
		Student s3 = new Student("Candy", 100);
		Student s4 = new Student("Bruce", 64);
		Student s5 = new Student("Ben", 56);
		
		
		/* sList 방식 */
		ArrayList<Student> sList = new ArrayList<>();
		boolean tf = sList.add(s1); // True
		sList.add(s2);
		sList.add(s3);
		sList.add(s4);
		sList.add(s5);
		
		for(int i = 0; i < sList.size(); i++) {
			Student result = sList.get(i);
			System.out.println(result);
		}
		
		int count = 0;
		for(int i = 0; i < sList.size(); i++) {
			if(sList.get(i).getScore() < 60) {
				count++;
			}
		}
		System.out.println("낙제 학생의 수는 " + count + "명 입니다.");
		
		/* for(배열의 요소 타입 변수 선언 : 배열) {
			배열의 자료를 하나 씩 꺼내서 변수 선언 부에 하나 씩 넣어줌.
			- 향상된 for 문
		} */
		
		for(Student stu : sList) {
			System.out.println(stu);
		}
		
		/* 배열 방식
		Student[] students = new Student[5];

		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		students[3] = s4;
		students[4] = s5;
		
		for(int i = 0; i < 5; i++) {
			System.out.println(students[i]);
		}

		int count = 0;
		for(int i = 0; i < 5; i++) {
			if(students[i].getScore() < 60) {
				count++;
			}
		}
		System.out.println("낙제 학생의 수는 " + count + "명 입니다.");
		*/
	}

}
