package chapter04;

import chapter04_vo.Member;
import chapter04_vo.Order;

public class OrderTest {

	public static void main(String[] args) {
		Member member = new Member();
		member.setId("abc123");
		member.setName("홍길순");
		member.setAdress("서울시 영등포구 여의도동 20번지");
		
		Order o = new Order("202503280001", 2025, 03, 28, member, "PD0345-12");
		System.out.println(o.toString());

	}

}
