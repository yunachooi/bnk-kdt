package chapter05_vo;

public class Tteokguk extends Eat{
	public Tteokguk() {
		
	}
	public void take() {
		System.out.println("떡국을 먹었습니다.");
		EatPerson.age += 1;
	}
}
