package chapter04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSearchTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("홍길동");
		list.add("전우치");
		list.add("손오공");
		
		Collections.sort(list);
		
		int idx1 = Collections.binarySearch(list, "멀린");
		
		if(idx1 == -1) {
			System.out.println("해당 데이터는 리스트에 없습니다.");
		}
		else {
			System.out.println("해당 데이터는 " + idx1 + "번 위치에 있습니다.");
		}
	}

}
