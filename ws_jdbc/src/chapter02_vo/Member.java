package chapter02_vo;

import lombok.Data;

@Data
public class Member {
	
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String grade = "C";
	
	@Override
	public String toString() {
		return String.format("%-5s", id) + " " + String.format("%-10s", pw) + " " + String.format("%-10s", name) + " " + 
		String.format("%-13s", phone) + " " + String.format("%-2s", grade);
	}
}
