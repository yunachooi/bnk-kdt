package chapter02_vo;

import java.util.Scanner;

public class Board {
Scanner sc = new Scanner(System.in);
	private int bno;
	private String title;
	private String content;
	private String regdate;
	private String writer;
	
	public Board(){
		
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", writer="
				+ writer + "]";
	}
	
	
	
}
