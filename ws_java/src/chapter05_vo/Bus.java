package chapter05_vo;

public class Bus extends Transportation {
	void goBus() {
		System.out.println("부산행 버스에 몸을 싣고...");
	}
	@Override
	public void go(){
		System.out.println("부산행 버스에 몸을 싣고...");
	}
}
