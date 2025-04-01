package chapter05_vo;

public class Transportation {
	// final = 상수 (수정 불가 / 오버라이딩 불가)
	// 추상메서드 (완성되지 않은 메서드) -> 상속을 위함, 자신의 인스턴스 생성 불가.
	// 상속받는 매체들 간의 약속. (추상 클래스는 반드시 메서드 구현, 따라서 추상 메서드 사용)
	// public void go();
	
	public void go() {
		System.out.println("알아서 갑니다...");
	}
	public void goBusan(Transportation t) {
		t.go();
	}
	
	
}
