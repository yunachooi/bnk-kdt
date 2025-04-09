package chapter10;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		//key : 번호
		//value : 이름
		map.put(1, "aaa");
		map.put(2, "bbb");
		map.put(3, "ccc");
		
		String value = map.get(3);
		System.out.println(value);
	}

}
