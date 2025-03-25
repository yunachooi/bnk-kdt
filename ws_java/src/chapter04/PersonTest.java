package chapter04;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person('F');
		Person p3 = new Person(27);
		Person p4 = new Person("Ann");
		Person p5 = new Person('F', 27);
		Person p6 = new Person('F', "Ann");
		Person p7 = new Person(27, "Ann");
		Person p8 = new Person('F', 27, "Ann");
	}

}
