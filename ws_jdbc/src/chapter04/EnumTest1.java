package chapter04;

enum Day{
	MONDAY, THESDAY, WENDSDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumTest1 {

	public static void main(String[] args) {
		Day today = Day.FRIDAY;
		
		switch(today) {
		case MONDAY -> System.out.println("월요일");
		case THESDAY -> System.out.println("화요일");
		case WENDSDAY -> System.out.println("수요일");
		case THURSDAY -> System.out.println("목요일");
		case FRIDAY -> System.out.println("금요일");
		case SATURDAY -> System.out.println("토요일");
		case SUNDAY -> System.out.println("일요일");
		}
	}

}
