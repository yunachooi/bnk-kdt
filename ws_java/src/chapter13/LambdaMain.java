package chapter13;

import java.util.Random;

interface Printable{
	void print(String s);
}

interface Calculater{
	void calc(int a, int b);
}

interface Calculater2{
	int calc(int a, int b);
}

interface HowLong{
	int len(String s);
}

interface Generator{
	int rand();
}

public class LambdaMain {
	public static void main(String[] args) {
		/* Lambda 표기법
		 * 1. 매개변수가 없을 때는 괄호 () 필수
		 * 2. 실행문이 한 줄 이상 일 경우 {} 필수
		 * 3. 리턴문만 있을 경우 return 생략
		 * */
		
		//매개변수가 없음, 리턴 있음
		Generator gen = () -> {
			Random rand = new Random();
			return rand.nextInt(6);
		};
		int rdNum = gen.rand();
		System.out.println(rdNum);
		
		//파라미터 1개, 리턴 있음
		HowLong hl = s -> s.length();
		int length = hl.len("Hello Java");
		System.out.println(length);
		
		//파라미터 2개, 리턴 있음
		Calculater2 c1;
		c1 = (a, b) -> {return a + b;};
		int result = c1.calc(1, 3);
		System.out.println(result);
		
		c1 = (a, b) -> a - b;
		result = c1.calc(1, 2);
		System.out.println(result);
		
		//파라미터 2개, 리턴 없음
		Calculater c;
		c = (a, b) -> System.out.println(a + b);
		c.calc(1, 2);
		
		c = (a, b) -> System.out.println(a - b);
		c.calc(1, 2);
		
		//파라미터 1개, 리턴 없음
		Printable p;
		p = (String s) -> {System.out.println(s);};
		p.print("aaa");
		
		p = (String s) -> System.out.println(s);
		p.print("bbb");
		
		p = (s) -> System.out.println(s);
		p.print("ccc");
		
		p = s -> System.out.println(s);
		p.print("ddd");
	}
}
