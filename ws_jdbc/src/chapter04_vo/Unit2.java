package chapter04_vo;

@FunctionalInterface
public interface Unit2 {

//	함수형 인터페이스여야만 람다식을 사용 가능
//	람다식을 사용할 때는 반드시 메서드가 하나만 존재.
//	void move(String s);
//	void move(String s, int i);
	int move(String s);
}
