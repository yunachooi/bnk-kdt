package chapter04;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InteratorTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("aaa", "bbb", "ccc");
		
		/* 방법 1 */
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		
		/* 방법 2 */
		System.out.println();
		for(String s : list) { //반복의 횟수를 지정할 수 없고, 처음부터 끝까지 순서대로 처리
			System.out.print(s + "\t");
		}
		
		/* 방법 3 */
		System.out.println();
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) { //반복의 횟수를 지정할 수 있으며, 제어 가능, 향상된 for문과 동일
			System.out.print(itr.next() + "\t");
		}
	}

}
