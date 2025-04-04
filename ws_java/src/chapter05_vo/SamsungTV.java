package chapter05_vo;

public class SamsungTV implements TV {
	public SamsungTV(){
		System.out.println("----------------");
		System.out.println("SamsungTV를 실행합니다...");
		System.out.println("----------------");
	}
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
