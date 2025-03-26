package chapter04;

import vo.MyDate;

public class MyDateTest {

	public static void main(String[] args) {
		MyDate ymd = new MyDate();
		ymd.setYear(1999);
		ymd.setMonth(1);
		ymd.setDay(23);
		
		System.out.println(ymd);
	}

}
