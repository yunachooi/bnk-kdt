package chapter05;

import java.util.Scanner;

import chapter05_vo.BeanFactory;
import chapter05_vo.TV;

public class InterfaceTV {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BeanFactory factory = new BeanFactory();
		
		System.out.println("어떤 브랜드의 TV를 원하십니까?");
		System.out.print("Samsung과 Lg가 있습니다. 선택하세요 >> ");
		String brand = sc.nextLine();
		
		TV tv = factory.getBean(brand);
		
		if(tv == null) {
			System.out.println("해당되는 번호의 티비가 없습니다...");
		}
		else {
			tv.powerOn();
			tv.volumeUp();
			tv.volumeDown();
			tv.powerOff();
		}
	}

}
