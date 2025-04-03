package chapter05;

import chapter05_vo.AbstractB;
import chapter05_vo.AbstractC;
import chapter05_vo.IB;


public class InterfaceB {

	public static void main(String[] args) {
		IB[] ib = new IB[2];
		AbstractB ab = new AbstractB();
		AbstractC ac = new AbstractC();
		
		ib[0] = ab;
		ib[1] = ac;
		
		for(int i = 0; i < 2; i++) {
			ib[i].f1();
			ib[i].f2();
		}
	}

}
