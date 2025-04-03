package chapter05_vo;

public class LgTV implements TV {
	@Override
	public void powerOn() {
		System.out.println("LgTV 전원 온...");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV 전원 오프...");
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV 볼륨 업...");
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV 볼륨 다운...");
	}
}
