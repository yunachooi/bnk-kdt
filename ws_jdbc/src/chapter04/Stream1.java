package chapter04;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Stream1 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		/*
		Stream : 데이터의 흐름
		Stream에서 수행하는 연산은 기존 자료를 변경하지 않음. (원본 훼손 X)
		Stream은 자료의 흐름이자 Collection(데이터 뭉치) 중의 하나의 기능
		-중간연산
		fliter() : 조건에 맞는 자료 추출
		map() : 자료를 특정한 형태로 변환
		sorted() : 정렬
		distict() : 중복제거
		limit() : 스트림 범위 제한
		skip() : 스트림 내 데이터 중 앞에서 n개 요소 건너 뜀
		-최종연산
		collect() : 콜렉션 자료를 만들어 변환
		forEach() : 각 요소에 대한 작업 수행
		count() : 요소 갯수 변환
		reduce() : 요소들의 하나의 결과로 만들기
		anyMatch(), allMath() : 조건 검사
		*/
		
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