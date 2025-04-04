package chapter05_vo;

public class ColorPrinter implements Printable {
	@Override
	public void print(Document doc) {
		System.out.println("---------------");
		System.out.println(doc.getContent());
		System.out.println("---------------");
		System.out.println("컬러로 프린트합니다.");
	}
}
