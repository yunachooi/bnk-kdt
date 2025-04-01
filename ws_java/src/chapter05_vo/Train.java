package chapter05_vo;

public class Train extends Transportation {
	void goTrain() {
		System.out.println("부산행 기차에 몸을 싣고...");
	}
	@Override
	public void go() {
		System.out.println("부산행 기차에 몸을 싣고...");
	}
}
