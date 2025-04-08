package chapter06_vo;

import java.util.Scanner;

public class Membership {
	Scanner sc = new Scanner(System.in);
	
	private String id;
	private String pwd;
	private String name;
	
	public Membership() {
		System.out.println("회원가입을 진행합니다.");
		System.out.print("아이디, 비밀번호, 이름 순으로 입력하세요 >> ");
		id = sc.next();
		pwd = sc.next();
		name = sc.next();
		
		System.out.println("계정이 성공적으로 생성되었습니다!");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Membership [id=" + id + ", pwd=" + pwd + ", name=" + name + "]";
	}
	
	
	
}
