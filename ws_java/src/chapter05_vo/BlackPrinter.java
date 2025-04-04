package chapter05_vo;

public class BlackPrinter implements Printable {
	@Override
	public void print(Document doc) {
		System.out.println("---------------");
		System.out.println(doc.getContent());
		System.out.println("---------------");
		System.out.println("흑백으로 프린터 합니다.");
	}
}
