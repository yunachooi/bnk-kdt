package chapter04;

import java.util.List;

public class StreamFinalTest {

	public static void main(String[] args) {
		List<String> words = List.of("hello", "hi", "world");
		
		boolean result = words.stream()
//			.anyMatch(s -> s.length() < 3); //길이가 3 미만인 단어 존재 여부
			.allMatch(s -> s.length() < 3);
		
		if(result) {
			System.out.println("있어요...");
		}
		else {
			System.out.println("없어요...");
		}
	}

}
