package chapter04;

import chapter04_vo.HumanCamp2;
import chapter04_vo.Unit;

public class AnnoymousInner1Test {

	public static void main(String[] args) {
		HumanCamp2 hc = new HumanCamp2();
		Unit unit = hc.getMarine();
		unit.move();
	}	

}
