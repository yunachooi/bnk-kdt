package chapter04_vo;

import lombok.Data;

@Data
public class User {
	private int no;
	private String name;
	private String gender;
	private int price;

	UserGrade grade = UserGrade.GOLD;
	
	public void pay(int price) {
		this.price = price;
		System.out.println(grade.getKorName() + " " + name + "회원님은 "  + grade.getDiscountRate(price) + "원을 지불했습니다.");
	}
}
