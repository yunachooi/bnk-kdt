package chapter05_vo;

public class BlackPrinter implements Printable {
	public void print(Document doc) {
		doc.write();
		System.out.println("흑백으로 프린트 합니다...");
		System.out.println(doc.s);
	}
}
