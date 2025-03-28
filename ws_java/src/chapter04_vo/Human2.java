package chapter04_vo;

public class Human2 {
	public static int cnt; // 공유되어짐
	public int id;
	public char gender;
	
	public Human2(char gender) {
		id = ++cnt;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
}
