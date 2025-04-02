package chapter05_vo;

public class OpticalMouse extends WheelMouse {
	@Override
	public void clickLift() {
		System.out.println("광센서로 왼쪽 클릭...");
	}
	@Override
	public void clickRight() {
		System.out.println("광센서로 오른쪽 클릭...");
	}
}
