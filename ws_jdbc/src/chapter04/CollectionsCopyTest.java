package chapter04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsCopyTest {

	public static void main(String[] args) {
		//IMutable 객체 생성
		List<String> src = Arrays.asList("홍길동", "전우치", "손오공", "멀린");
		
		//수정가능한 리스트로 생성
		List<String> dst = new ArrayList<>(src);
		System.out.println(dst);
		//정렬 수행
		Collections.sort(dst);
		System.out.println(dst);
		//정렬 이전의 상태로 돌아감
		Collections.copy(dst, src);
		System.out.println(dst);
		//수정가능한 상태인지 확인 (Mutable 객체)
		dst.remove(0);
		System.out.println(dst);
	}

}
