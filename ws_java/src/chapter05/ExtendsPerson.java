package chapter05;

import chapter05_vo.Person;
import chapter05_vo.Student;
import chapter05_vo.Worker;

public class ExtendsPerson {

	public static void main(String[] args) {
		Student s1 = new Student();
		Worker w1 = new Worker();
		Person p1 = new Person();

		Person[] people = new Person[3];
		people[0] = s1;
		people[1] = w1;
		people[2] = p1;
		
		Student x = (Student)people[0];
		x.num = 23;
		System.out.println(x.num);
	}

}
