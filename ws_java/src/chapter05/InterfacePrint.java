package chapter05;

import chapter05_vo.BlackPrinter;
import chapter05_vo.ColorPrinter;
import chapter05_vo.Document;
import chapter05_vo.Printable;

public class InterfacePrint {

	public static void main(String[] args) {
		Printable black = new BlackPrinter();
		Printable color = new ColorPrinter();
		Document doc = new Document();
		
		black.print(doc);
		color.print(doc);
	}

}
