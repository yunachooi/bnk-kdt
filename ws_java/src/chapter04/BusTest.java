package chapter04;

import chapter04_vo.Bus;
import chapter04_vo.BusStudent;

public class BusTest {

	public static void main(String[] args) {
		Bus bus123 = new Bus(123);
		BusStudent bs = new BusStudent("홍길동", 1, 5000);
		BusStudent bs1 = new BusStudent("홍길순", 1, 2000);
		bs.takeBus(bus123);
		bs1.takeBus(bus123);
		
		System.out.println(bs.showInfo());
		System.out.println(bs1.showInfo());
		System.out.println(bus123.showInfo());
	}

}
