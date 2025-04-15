package chapter04_vo;

import lombok.Data;

@Data
public class Book {
	private int bno;
	private String title;
	private String author;
	private String publisher;
	private int price;
}
