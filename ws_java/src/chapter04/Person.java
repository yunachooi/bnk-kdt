package chapter04;

public class Person {
	char gender;
	int age;
	String name;
	
	Person(){
		System.out.println("0번째 생성자");
	}
	Person(char gender){
		this.gender = gender;
		System.out.println("1번째 생성자");
	}
	Person(int age){
		this.age = age;
		System.out.println("2번째 생성자");
	}
	Person(String name){
		this.name = name;
		System.out.println("3번째 생성자");
	}
	Person(char gender, int age){
		this.gender = gender;
		this.age = age;
		System.out.println("4번째 생성자");
	}
	Person(char gender, String name){
		this.gender = gender;
		this.name = name;
		System.out.println("5번째 생성자");
	}
	Person(int age, String name){
		this.age = age;
		this.name = name;
		System.out.println("6번째 생성자");
	}
	Person(char gender, int age, String name){
		this(gender, age);
		this.name = name;
		System.out.println("7번째 생성자");
	}
}
