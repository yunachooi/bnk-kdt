package chapter05;

import chapter05_vo.Eat;
import chapter05_vo.EatPerson;
import chapter05_vo.Ramen;
import chapter05_vo.Tteokguk;

public class EatTteokguk {

	public static void main(String[] args) {
		Tteokguk tteokguk = new Tteokguk();
		Ramen ramen = new Ramen();
		Eat eat = new Eat();
		EatPerson person = new EatPerson("홍길동", 17, 50);
		
		eat.take(tteokguk);
		eat.take(ramen);
		
		System.out.println(person.toString());
	}

}
