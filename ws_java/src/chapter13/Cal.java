package chapter13;

import chapter13_vo.Calculator;

public class Cal {
	public static void main(String[] args) {
		Calculator add = (x, y) -> System.out.println("덧셈을 수행하는 람다식 : " + (x + y));
		Calculator minus = (x, y) -> System.out.println("뺄셈을 수행하는 람다식 : " + (x - y));
		
		add.calc(1, 1);
		minus.calc(1, 1);
	}
}