package chapter05_vo;

public class BeanFactory {
	public TV getBean(int n){
		if(n == 1) {
			return new SamsungTV();
		}
		else if(n == 2) {
			return new LgTV();
		}
		return null;
	}
}
