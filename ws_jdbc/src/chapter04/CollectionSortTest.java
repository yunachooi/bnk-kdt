package chapter04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionSortTest {

	public static void main(String[] args) {
		// 읽기만 가능한 불변자료
		List<String> list = Arrays.asList("홍길동", "전우치", "손오공");
		for (String s : list) {
			System.out.print(s + "\t");
		}
//		list.add("멀린"); 오류 발생

		list = new ArrayList<String>(list);
		list.add("멀린");
		System.out.println();
		for (String s : list) {
			System.out.print(s + "\t");
		}

		// 해당 리스트 자료의 요소로 쓰는 객체에 클래스를 정의할 때 Comparable을 정의해야 정렬 메서드를 바르게 사용할 수 있음.
		Collections.sort(list); // 기본 설정 : 오름차순
		System.out.println();
		for (String s : list) {
			System.out.print(s + "\t");
		}

	}
}
