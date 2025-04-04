package chapter05;

import chapter05_vo.ItsMe;

public class InterfaceItsMe {

	public static void main(String[] args) {
		ItsMe me = new ItsMe();
		me.fly();
		me.run();
		me.speak();
	}
}
