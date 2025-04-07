package chapter06;

import java.util.Scanner;

import chapter06_vo.Customer;

public class CustomerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Customer c = new Customer("홍길동", "010-1234-5678", 1000000);
		Customer c2 = new Customer("홍길은", "010-1111-2222", 99999);
	}

}
