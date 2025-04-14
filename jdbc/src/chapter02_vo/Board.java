package chapter02_vo;

import java.util.Scanner;

import lombok.Data;

@Data
public class Board {
Scanner sc = new Scanner(System.in);
	private int bno;
	private String title;
	private String content;
	private String regdate;
	private String writer;
	
	@Override
	public String toString() {
		return String.format("%-4s", bno) + " " + String.format("%-10s", title) + " " + String.format("%-20s", content) + " " + 
				String.format("%-20s", regdate) + " " + String.format("%-4s", writer);
	}
}
