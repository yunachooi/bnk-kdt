package chapter06;

import java.util.ArrayList;
import java.util.Scanner;

import chapter06_vo.Student;

public class Student2Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Student s1 = new Student("James", 93);
		Student s2 = new Student("Ann", 46);
		Student s3 = new Student("Candy", 100);
		Student s4 = new Student("Bruce", 64);
		Student s5 = new Student("Ben", 56);

		ArrayList<Student> sList = new ArrayList<>();
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		sList.add(s4);
		sList.add(s5);

		boolean flag = true;
		while (flag) {
			System.out.print("학생의 번호와 이름을 입력하시오. >> ");
			int no = sc.nextInt();
			String name = sc.next();

			for (int i = 0; i < sList.size(); i++) {
				if (sList.get(i).getSno() == no && sList.get(i).getSname().equals(name)) {
					System.out.println(sList.get(i).getSno() + "번 " + sList.get(i).getSname() + " 학생의 점수는 "
							+ sList.get(i).getScore() + "점 입니다.");
					flag = false;
				}
			}
			if (flag) {
				System.out.println("학생의 번호나 이름을 확인하세요.");
				System.out.println("-------------");
			}
		}
		System.out.println("-------------");
	}
}
