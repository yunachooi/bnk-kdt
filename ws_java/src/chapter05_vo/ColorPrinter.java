package chapter05_vo;

public class ColorPrinter implements Printable {
	public void print(Document doc) {
		doc.write();
		System.out.println("컬러로 프린트 합니다...");
		System.out.println(doc.s);
	}
}
