package chapter04_vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person implements Comparable<Person> {
	private String name;
	private int age;
	
	@Override
	public int compareTo(Person o) {
		return this.age - o.age; //나이기준 정렬
//		return this.name.compareTo(o.name); //이름기준 정렬
	}
}
