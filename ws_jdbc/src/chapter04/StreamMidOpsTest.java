package chapter04;

import java.util.List;
import java.util.stream.Collectors;

public class StreamMidOpsTest {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(10, 20, 30, 40, 50, 60, 70);
		
//		numbers.stream()
//			.skip(2)
//			.limit(3)
//			.forEach(System.out::println);
		
		List<Integer> results = numbers.stream()
				.skip(2)
				.limit(3)
				.collect(Collectors.toList());
		
		System.out.println(results);
		
		int sum = results.stream()
			.reduce(0, (a, b) -> a + b);
		
		System.out.println(sum);
	}

}
