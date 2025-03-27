package chapter04;

import chapter04_vo.Human;

public class HumanTest {

	public static void main(String[] args) {
		Human h1 = new Human();
		h1.setName("김철수");
		h1.setAge(500);
		System.out.println(h1);
		System.out.println("--------------------");
		
		Human h2 = new Human("홍길동", 20);
		System.out.println(h2);
	}

}
