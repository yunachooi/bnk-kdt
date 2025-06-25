package chapter13;

import java.util.function.BiPredicate;

public class PredicateTest3 {
	public static void main(String[] args) {
		//Predicate<T> : T 타입을 판별한다. --> test()
		
		//BiPredicate<T, U> 예제
		//"Robot"이라는 문자열의 길이가 3을 초과했는지 여부를 판별하는 코드작성.
		
		BiPredicate<String, Integer> conv = (s, n) -> s.length() > n;
		
		if(conv.test("Robot", 3)) {
			System.out.println("문자열의 길이가 3을 초과했습니다.");
		} else {
			System.out.println("문자열의 길이가 3이하 입니다.");
		}
		
	}
}