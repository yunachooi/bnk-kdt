package chapter04_vo;

public class Personal {
	String name;
	String ymd;
	Student student;
	
	public Personal(String name, String ymd, Student student){
		this.name = name;
		this.ymd = ymd;
		this.student = student;
	}

	@Override
	public String toString() {
		return "이름 : " + name + " 생년월일 : " + ymd + "\n학교 : " + student.getSchool() + 
				" 학년 : " + student.getGrade() + " 번호 : " + student.getId();
	}
}
