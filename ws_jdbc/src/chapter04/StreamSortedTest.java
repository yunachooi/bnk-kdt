package chapter04;

import java.util.Arrays;
import java.util.List;

public class StreamSortedTest {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동", "멀린", "해리포터");
		list.stream() //1. 스트림 생성
			.sorted() //2. 중간 연산(정렬)
			.forEach(n -> System.out.print(n + "\t")); //3. 최종 연산(요소를 하나씩 꺼내서 소비)
		
		System.out.println();
		list.stream()
			.sorted((s1, s2) -> s1.length() - s2.length())
			.forEach(n -> System.out.print(n + "\t"));
	}
}
