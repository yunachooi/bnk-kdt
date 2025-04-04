package chapter05_vo;

import java.util.Scanner;

public class Document {
	Scanner sc = new Scanner(System.in);
	private String content;
	
	public Document(){
		
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	public String write() {
		System.out.println("프린터할 문서를 작성하세요! ▼");
		String content = sc.nextLine();
		
		while(true) {
			String s = sc.nextLine();
			if(s.equals("출력")) {
				System.out.println("문서 작성이 완료되었습니다.");
				break;
			}
			content += "\n" + s;
		}
		return content;
	}
}
