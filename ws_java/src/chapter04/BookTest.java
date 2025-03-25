package chapter04;

public class BookTest {

	public static void main(String[] args) {
		Book b = new Book("책 이름", "A", "홍길동", "호러", 26000);
		
		System.out.println("책 이름 >> " + b.getTitle());
		System.out.println("출판사 >> " + b.getPublisher());
		System.out.println("저자 >> " + b.getWriter());
		System.out.println("-----------------");
		
		b.setTitle("변경된 책 이름");
		b.setPublisher("B");
		b.setWriter("홍");
		
		System.out.println("책 이름 >> " + b.title);
		System.out.println("출판사 >> " + b.publisher);
		System.out.println("저자 >> " + b.writer);
		
		System.out.println("-------책 정보-------");
		System.out.println(b.bookInfotoString());
	}

}