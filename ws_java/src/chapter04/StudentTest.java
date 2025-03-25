package chapter04;

import java.util.Arrays;

public class StudentTest {

	public static void main(String[] args) {
		Student james = new Student();
		Student ann = new Student();
		Student bread = new Student();
		
		int sum = 0;

		james.no = 1;
		james.name = "james";
		james.kor_score = 100;
		james.eng_score = 90;
		james.math_score = 80;

		ann.no = 2;
		ann.name = "ann";
		ann.kor_score = 70;
		ann.eng_score = 60;
		ann.math_score = 50;

		bread.no = 3;
		bread.name = "bread";
		bread.kor_score = 40;
		bread.eng_score = 30;
		bread.math_score = 20;

		Student[] student = new Student[3];
		student[0] = james;
		student[1] = ann;
		student[2] = bread;
		
		for(int i = 0; i < 3; i++) {
			sum += student[i].kor_score;
		}

		System.out.println(sum);
	}

}
