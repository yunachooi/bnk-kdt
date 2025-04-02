package chapter05_vo;

public class Ramen extends Eat {
	public Ramen() {
		
	}
	
	public void take(){
		System.out.println("라면을 먹었습니다.");
		EatPerson.weight += 1;
	}
}
