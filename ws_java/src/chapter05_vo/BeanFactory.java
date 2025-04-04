package chapter05_vo;

public class BeanFactory {
	public TV getBean(String tv){
		if(tv.equals("samsung")) {
			return new SamsungTV();
		}
		else if(tv.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
}
