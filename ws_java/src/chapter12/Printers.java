package chapter12;

import chapter12_vo.Printable;

class Printers {

	public static void main(String[] args) {
//		방법 1 (클래스 이용)
//		Printable p = new Printer();
		
//		방법 2 (익명 클래스 이용)
//		Printable p = new Printable() {
//			
//			@Override
//			public void print(String s) {
//				System.out.println(s);
//			}
//		};
		
//		방법 3 (람다 표현식)
		Printable p = (s) -> System.out.println(s);
		
		p.print("Lambda 테스트...");
	}	
		
		
}
