package chapter12;

import chapter12_vo.Converter;

public class Convert {
	public static void main(String[] args) {
		Converter upper = (s) -> s.toUpperCase();
		Converter lower = (s) -> s.toLowerCase();
		
		System.out.println(upper.text("Hello"));
		System.out.println(lower.text("HELLO"));
	}

}
