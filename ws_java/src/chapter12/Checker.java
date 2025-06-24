package chapter12;

import chapter12_vo.NumberChecker;

public class Checker {
	public static void main(String[] args) {
		NumberChecker isOdd = (n) -> n % 2 == 0;
		NumberChecker isEven = (n) -> n % 2 != 0;
		NumberChecker isOne = (n) -> n == 1;
		
		System.out.println("짝수? " + isOdd.check(5));
		System.out.println("홀수? " + isEven.check(5));
		System.out.println("숫자 1? " + isOne.check(1));
	}
}
