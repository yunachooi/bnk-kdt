package chapter05_vo;

public interface IB {
	// 인터페이스는 문법 상 모든 함수가 추상 메소드.
	// 인터페이스는 관계가 없는 클래스가 마치 상속받은 것 처럼 하나의 타입으로 묶임. (동변상련)
	// 상속 = 부모가 같아야 함.(유사성 필요, 공통점)
	/* public abstract 생략 */ void f1();
	int f2();
}
