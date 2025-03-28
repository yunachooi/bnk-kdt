package chapter04_vo;

public class BusStudent {
	String name;
	int grade;
	int money;
	
	public BusStudent(String name, int grade, int money){
		this.name = name;
		this.grade = grade;
		this.money = money;
	}
	
	public void takeBus(Bus bus) {
		money -= 1000;
		bus.take(1000);
	}

	public String showInfo() {
		return "이름 : " + name + ", 학년 : " + grade + ", 가진 돈 : " + money + "원";
	}
	
	
}
