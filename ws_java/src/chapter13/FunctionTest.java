package chapter13;

import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionTest {
	public static void main(String[] args) {
		/* Function<T, R> T 타입을 파라미터로 받아 R타입을 반환.
		 * */
		Function<String, Integer> f = s -> s.length();
		
		int length = f.apply("Robot");
		Consumer<Integer> ci = n -> System.out.println(n);
		ci.accept(length);
	}
}
