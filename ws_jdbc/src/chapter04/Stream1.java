package chapter04;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Stream1 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		//Stream : 데이터의 흐름
		//Stream에서 수행하는 연산은 기존 자료를 변경하지 않음. (원본 훼손 X)
		//1. 스트림 생성
		IntStream stm1 = Arrays.stream(arr);
		
		//2. 중간 연산
		IntStream stm2 = stm1.filter(n -> n % 2 == 1);
		
		//3-1. 최종 연산(홀수)
		int sum = stm2.sum();
		
		//3-2. 최종 연산(짝수) = 파이프라인 형성, 메서드 체이닝
		int sum2 = Arrays.stream(arr) 
				.filter(n -> n % 2 == 0)
				.sum();
		
		System.out.println("홀수의 합 >> " + sum);
		System.out.println("짝수의 합 >> " + sum2);
	}
}