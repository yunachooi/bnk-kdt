package chapter05_vo;

import java.util.Scanner;

public class PrinterSelector {
	Scanner sc = new Scanner(System.in);
	
	public void select(Document doc) {
		Printable printer;
		
		System.out.print("컬러와 흑백을 선택하여주세요 >> ");
		String input = sc.nextLine();
		
		if(input.equals("흑백")) {
			printer = new BlackPrinter();
		}
		else {
			printer = new ColorPrinter();
		}
		
		printer.print(doc);
	}
}
