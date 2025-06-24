package chapter12;

import chapter12_vo.Calculator;

public class Cal {
	public static void main(String[] args) {
		Calculator add = (x, y) -> System.out.println("덧셈을 수행하는 람다식 : " + (x + y));
		Calculator minus = (x, y) -> System.out.println("뺄셈을 수행하는 람다식 : " + (x - y));
		
		add.calc(1, 1);
		minus.calc(1, 1);
		
		System.out.println("-------------");
		f(2, 2, add);
		f(2, 2, minus);
		
	}
	
	public static void f(int x, int y, Calculator calcu) {
		calcu.calc(x, y);
	}
}