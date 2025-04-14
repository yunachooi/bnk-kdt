package chapter02_vo;

public class Member {
	
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String grade = "C";
	
	public Member(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String string) {
		this.grade = string;
	}

	@Override
	public String toString() {
		return String.format("%-5s", id) + " " + String.format("%-10s", pw) + " " + String.format("%-10s", name) + " " + 
		String.format("%-13s", phone) + " " + String.format("%-2s", grade);
	}
}
