package chapter13;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest2 {
	public static void main(String[] args) {
		//정수 리스트를 넣으면 3의 배수가 몇 개인지를 알려주는 코드를 작성하시오.
		List<Integer> list = Arrays.asList(1, 3, 5, 7, 9, 11, 13);
		
		Function<List<Integer>, Integer> f = l -> {
			int total = 0;
			
			for(int num : l) {
				if(num % 3 == 0) {
					total += 1;
				}
			}
			
			return total;
		};
		
		System.out.println("3의 배수는 " + f.apply(list) + "개 입니다.");
	}
}
