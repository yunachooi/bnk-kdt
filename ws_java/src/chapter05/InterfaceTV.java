package chapter05;

import chapter05_vo.BeanFactory;
import chapter05_vo.TV;

public class InterfaceTV {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		TV tv = factory.getBean(1);
		
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
