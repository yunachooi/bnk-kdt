package chapter03;

import java.util.HashSet;

import chapter03_vo.Member;

public class MemberTest {

	public static void main(String[] args) {
		//두개의 멤버 인스턴스 비교
		//==는 주소를 비교
		Member m1 = new Member();
		m1.setMno(1);
		m1.setName("aaa");
		m1.setPhone("010-1111-1111");
		System.out.println(m1);
		
		Member m2 = new Member();
		m2.setMno(1);
		m2.setName("aaa");
		m2.setPhone("010-1111-1111");
		System.out.println(m2);
		
		System.out.println("equals >> " + m1.equals(m2)); //false, 인스턴스를 비교해야하는 클래스를 정의할 때 반드시 equals 메서드를 재정의. 정의하지 않을 경우 주소 비교.

		System.out.println("m1 == m2 >> " + (m1 == m2)); //false
		
		Member m3 = m1;
		System.out.println("m1 == m3 >> " + (m1 == m3)); //true
		
		//멤버타입을 저장할 hashset 생성, 중복된 데이터는 들어지 않음.
		//equals와 hashcode를 같이 오버라이딩하는 것이 원칙.
		HashSet<Member> Llist = new HashSet<>();
		
		Llist.add(m1);
		Llist.add(m2);
		System.out.println("Llist size >> " + Llist.size());
	}

}
