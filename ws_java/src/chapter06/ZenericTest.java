package chapter06;

import java.util.ArrayList;

import chapter06_vo.Box;
import chapter06_vo.X;

public class ZenericTest {

	public static void main(String[] args) {
		// 멤버변수의 타입이 String으로 정해짐. 
		Box<String> box = new Box<>();
		box.t = "hello";
		System.out.println(box.t);
		
		// 멤버변수의 타입이 x의 타입인 int로 정해짐.
		Box<X> xbox = new Box<>();
		xbox.t = new X();
		xbox.t.x = 10;
		System.out.println(xbox.t.x);
		
		ArrayList<String> sList = new ArrayList<>();
		sList.add("aaa");
		ArrayList<Integer> sList2 = new ArrayList<>();
		sList2.add(12);
		ArrayList<Character> sList3 = new ArrayList<>();
		sList3.add('a');
		sList3.add('b');
		
		System.out.println(sList);
		System.out.println(sList2);
		System.out.println(sList3);
	}

}
