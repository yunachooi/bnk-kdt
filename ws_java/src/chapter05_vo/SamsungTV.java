package chapter05_vo;

public class SamsungTV implements TV {
	@Override
	public void powerOn() {
		System.out.println("SamsungTV 전원 온...");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV 전원 오프...");
	}
	@Override
	public void volumeUp() {
		System.out.println("SamsungTV 볼륨 업...");
	}
	@Override
	public void volumeDown() {
		System.out.println("SamsungTV 볼륨 다운...");
	}
}
