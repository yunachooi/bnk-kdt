package chapter04;

public class Student3 {
	int no;
	String name;
	char gender;

	Student3(int no, String name, char gender) {
		this.no = no;
		this.name = name;
		this.gender = gender;
	}
	
	// 멤버 변수의 값을 외부로 반환해주는 함수 : 베터 함수
	int getNo() {
		return no;
	}
	String getName() {
		return name;
	}
	char getGender() {
		return gender;
	}
	
	 // 멤버변수의 값을 할당시키는 함수 : 세터 함수
	void setNo(int no) {
		this.no = no;
	}
	void setName(String name) {
		this.name = name;
	}
	void setGender(char gender) {
		this.gender = gender;
	}
	
	
}
