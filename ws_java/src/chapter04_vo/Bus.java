package chapter04_vo;

public class Bus {
	int bus_no;
	static int passinger;
	static int sum_money;
	
	public Bus(int bus_no) {
		this.bus_no = bus_no;
	}
	
	public void take(int sum_money){
		Bus.sum_money += sum_money;
		Bus.passinger += 1;
	}
	
	public String showInfo() {
		return "버스번호 : " + bus_no + ", 승객 수 : " + passinger + ", 받은 요금 총액 : " + sum_money + "원";
	}
}