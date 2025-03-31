package chapter04_vo;

// 주문정보
public class Order {
	String order_no;
	int y;
	int m;
	int d;
	String item_num;
	Member member;
	
	public Order(String num, int y, int m, int d, Member member, String item_num){
		this.order_no = num;
		this.y = y;
		this.m = m;
		this.d = d;
		this.member = member;
		this.item_num = item_num;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "주문번호: " + order_no + "\n주문자아이디: " + member.getId() + "\n주문날짜: " + 
				y + "년 " + m + "월 " + d + "일" + "\n이름: " + member.getName()
				+ "\n주문 상품 번호: " + item_num + "\n주소: " + member.getAdress();
	}
	
}
