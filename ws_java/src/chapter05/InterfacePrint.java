package chapter05;

import java.util.Scanner;

import chapter05_vo.Document;
import chapter05_vo.PrinterSelector;

public class InterfacePrint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Document doc = new Document();
		PrinterSelector ps = new PrinterSelector();
		
		doc.setContent(doc.write());
		ps.select(doc);
	}

}
