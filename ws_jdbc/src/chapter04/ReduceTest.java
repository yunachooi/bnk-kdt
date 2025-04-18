package chapter04;

import java.util.Arrays;
import java.util.List;

public class ReduceTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동", "전우치", "손오공", "해리포터");
		
		String name = list.stream()
				.reduce("이순신", (s1, s2) ->
						s1.length() >= s2.length() ? s1 : s2);
		//삼항연산자 - 조건 ? 참 : 거짓
		
		System.out.println(name);
		
	}

}
