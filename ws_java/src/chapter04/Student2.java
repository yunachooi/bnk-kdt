package chapter04;

// 생성자의 이름은 클래스의 이름으로 결정됨.
// 생성자의 역할은 생성자는 해당 클래스의 인스턴스가 만들어질 때 클래스의 멤버 변수의 값을 초기화하는 용도로 사용됨.
// 함수의 시그니처란 반환타입, 함수이름, 매개변수의 타입과 개수를 통칭.
// 함수(메서드)의 오버로딩 : 함수의 이름이 같아야함 단, 함수의 시그니처는 달라야함.
// . : ~의, ~을 통해서 접근할 수 있는
// this = 생성된 인스턴스, 생성자가 다른 생성자 호출
// 인스턴스 생성 : new 와 생성자 함수를 사용
// 생성자 함수는 클래스와 이름이 동일하며, 반환값이 없다.
// 생성자는 필요에 의해 여러 개 사용 가능.
// 생성자의 역할은 인스턴스의 값을 초기화하는 역할. 고정불변의 값은 아니며 세터(변경)와 베터(전달) 사용.

public class Student2 {
	int no;
	String name;
	char gender;

	Student2() {

	}

	Student2(int no, String name, char gender) {
		this.no = no;
		this.name = name;
		this.gender = gender;
	}

	Student2(int no, String name) {
		this.no = no;
		this.name = name;
	}
}