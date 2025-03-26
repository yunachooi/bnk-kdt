package chapter04;

import vo.PrivateN;

public class PrivateNTest {

	public static void main(String[] args) {
		PrivateN a = new PrivateN();
		a.setN(10); // 세팅
		a.setS("Hello");
		
		System.out.println(a.showInfo());
		System.out.println(a);
	}

}