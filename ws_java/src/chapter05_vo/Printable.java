package chapter05_vo;

public interface Printable {
	// interface 이름은 -able을 쓰는 경우가 많다.
	// 기능을 설명하기 위함.
	// 클래스의 상속은 단 하나의 클래스만 받을 수 있도록 제한.
	// but, interface를 통해서 구현체로 만들어서 다중 상속의 기능을 제공.
	abstract void print(Document doc);
}
