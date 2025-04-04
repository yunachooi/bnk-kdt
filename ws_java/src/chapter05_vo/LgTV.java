package chapter05_vo;

public class LgTV implements TV {
	public LgTV(){
		System.out.println("----------------");
		System.out.println("LgTV를 실행합니다...");
		System.out.println("----------------");
	}
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
