package chapter13;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

class Box<T> {
	private T ob;

	public void set(T o) {
		ob = o;
	}

	public T get() {
		return ob;
	}
}

public class ConsumerTest {
	public static void main(String[] args) {
		/*
		 * Consumer<T> 전달된 인자를 가지고 어떤 결과를 보여야 할 때 사용.
		 */
		Consumer<String> c = s -> System.out.println(s);
		c.accept("Hello~~");

		BiConsumer<String, Integer> bc = (s, i) -> System.out.println(i + ") " + s);
		bc.accept("James", 1);

		// BiConsumer<T, U>를 기반으로 Box<T> 클래스의 인스턴스에 String 형 데이터를 저장하는 기능의 람다식을 작성하시오.
		BiConsumer<Box<String>, String> bic = (box, s2) -> box.set(s2);
		Box<String> box = new Box<>();
		
		bic.accept(box, "John");
		System.out.println(box.get());
		
		Consumer<Box<String>> cb = box2 -> System.out.println(box2.get());
		cb.accept(box);
	}
}