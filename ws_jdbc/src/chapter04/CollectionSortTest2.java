package chapter04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chapter04_vo.StringDesc;

public class CollectionSortTest2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("홍길동");
		list.add("전우치");
		list.add("손오공");
		
		Collections.sort(list);
		System.out.println(list); //오름차순 정렬
		
		StringDesc cmp = new StringDesc();
		
		Collections.sort(list, cmp);
		System.out.println(list); //내림차순 정렬, 원본 데이터의 처리 방법에 대해 고민해야함.
	}

}
