package chapter04;

import chapter04_vo.Day2;

public class Day2Test {

	public static void main(String[] args) {
		for(Day2 day : Day2.values()) {
			System.out.println(day + " : " + day.getKorName() + ", " + day.getEngName());
		}
		
		Day2 today = Day2.FRIDAY;
		System.out.println("오늘은 " + today.getKorName() + "입니다.");
		System.out.println("Today is " + today.getEngName() + ".");
	}

}
