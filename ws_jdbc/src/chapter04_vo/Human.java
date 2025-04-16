package chapter04_vo;

public class Human implements Unit{

	@Override
	public void move() {
		System.out.println("인간이 움직입니다...");
	}
	
}