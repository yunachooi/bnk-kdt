package chapter04_vo;

public class Human {
	private String name;
	private int age;

	public Human() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		checkAge(age);
	}

	public Human(String name, int age) {
		this.name = name;
		checkAge(age);
	}

	public void checkAge(int age) {
		if (age < 1 || age > 201) {
			System.out.println("값의 허용범위를 벗어났어요.");
			this.age = 0;
		} else {
			this.age = age;
		}
	}

	@Override
	public String toString() {
		if (age == 0) {
			return "name = " + name + ", age = 미정";
		} else {
			return "이름 = " + name + ", 나이 = " + age;
		}
	}
}
