package chapter05_vo;

import java.util.Scanner;

public class Document {
	String s;
	Scanner sc = new Scanner(System.in);
	
	public Document(){
		
	}
	public String write() {
		System.out.print("프린터로 출력할 내용을 입력하세요 >> ");
		s = sc.next();
		System.out.println("---------------");
		return s;
	}
}
