package chapter05_vo;

public class EatPerson {
	String name;
	static int age;
	static double weight;
	
	public EatPerson(String name, int age, int weight){
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "이름 : " + name + ", 나이 : " + age + "세, 몸무게 : " + weight + "kg";
	}
	
}
