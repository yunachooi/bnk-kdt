package chapter04_vo;

enum UserGrade {
	GOLD("골드", 0.9),
	SILVER("실버", 0.85),
	BRONZE("브론즈", 1);

	private final String korName;
	private final double discountRate;
	
	UserGrade(String korName, double discountRate) {
		this.korName = korName;
		this.discountRate = discountRate;
	}
	
	public String getKorName() {
		return korName;
	}
	
	public int getDiscountRate(int price) {
		return (int) (price * discountRate);
	}
}
