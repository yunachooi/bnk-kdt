package chapter04;

public class Book {
	String title;
	String genre;
	String publisher;
	int price;
	String writer;
	
	Book(String title, String publisher, String writer, String genre, int price){
		this.title = title;
		this.publisher = publisher;
		this.writer = writer;
		this.genre = genre;
		this.price = price;
	}
	String getTitle() {
		return title;
	}
	String getPublisher() {
		return publisher;
	}
	String getWriter() {
		return writer;
	}
	
	void setTitle(String title) {
		this.title = title;
	}
	void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	void setWriter(String writer) {
		this.writer = writer;
	}
	
	String bookInfotoString() {
		return "책 정보 [제목 : " + title + ", 장르 : " + genre + ", 출판사 : " + publisher + ", 가격 : " + price
				+ "원, 작가 : " + writer + "]";
	}
}
