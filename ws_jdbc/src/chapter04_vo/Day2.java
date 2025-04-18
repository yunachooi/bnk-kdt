package chapter04_vo;

public enum Day2 {
	MONDAY("월요일", "MONDAY"),
	THESDAY("화요일", "THESDAY"),
	WENDSDAY("수요일", "WENDSDAY"),
	THURSDAY("목요일", "THURSDAY"),
	FRIDAY("금요일", "FRIDAY"),
	SATURDAY("토요일", "SATURDAY"),
	SUNDAY("일요일", "SUNDAY");
	
	private final String korName;
	private final String engName;
	
	Day2(String korName, String engName){
		this.korName = korName;
		this.engName = engName;
	}
	
	public String getKorName() {
		return korName;
	}
	public String getEngName() {
		return engName;
	}

}
