package vo;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate(){
		
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setMonth(int month) {
		monthList(month);
	}
	public void setDay(int day) {
		monthDay(day);
	}
	public void monthList(int month) {
		if(month > 13 || month < 0) {
			System.out.println("월의 범위를 벗어났습니다.");
			this.month = 0;
		}
		else {
			this.month = month;
		}
	}
	
	public void monthDay(int day) {
		if(this.month == 2) {
			if(this.year % 4 == 0) {
				if(day > 29) {
					System.out.println("일의 범위를 벗어났습니다.");
					this.day = 0;
				}
				else {
					this.day = day;
				}
			}
			else {
				if(day > 28) {
					System.out.println("일의 범위를 벗어났습니다.");
					this.day = 0;
				}
				else {
					this.day = day;
				}
			}
		}
		else if(this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12) {
			if(day > 31) {
				System.out.println("일의 범위를 벗어났습니다.");
				this.day = 0;
			}
			else {
				this.day = day;
			}
		}
		else {
			if(day > 30) {
				System.out.println("일의 범위를 벗어났습니다.");
				this.day = 0;
			}
			else {
				this.day = day;
			}
		}
	}
	
	@Override
	public String toString() {
		if(month == 0) {
			return year + "년 " + day + "일";
		}
		else if(day == 0) {
			return year + "년 " + month + "월 ";
		}
		else {
			return year + "년 " + month + "월 " + day + "일";
		}
		
	}
}
