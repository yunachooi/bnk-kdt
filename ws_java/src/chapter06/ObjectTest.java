package chapter06;

import chapter06_vo.InfinityObjectArray;

public class ObjectTest {

	public static void main(String[] args) {
		InfinityObjectArray ioa = new InfinityObjectArray();
		
		ioa.add("aaa");
		ioa.add("bbb");
		ioa.add("ccc");
		ioa.add(20);
		ioa.add(3.5);
		
		ioa.showArray();
	}

}
