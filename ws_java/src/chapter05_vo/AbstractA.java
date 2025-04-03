package chapter05_vo;

public class AbstractA extends AbstractParent {

	public AbstractA(int n){
		super(10);
		System.out.println("자식 A 클래스 생성자 호출...");
	}
	
	@Override
	public void af() {
		System.out.println("오버라이드된 af()함수 실행...");
	}

}
