package chapter04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chapter04_vo.Person;

public class PersonSortTest {

	public static void main(String[] args) {
		Person p1 = new Person("aaa", 20);
		Person p2 = new Person("bbb", 21);
		Person p3 = new Person("ccc", 22);
		Person p4 = new Person("ddd", 23);
		Person p5 = new Person("eee", 24);
		
		List<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		
		Collections.sort(list);
		System.out.println(list);
	}

}
