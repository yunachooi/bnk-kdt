package chapter10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> map = new HashMap<>();

		map.put("Apple", "사과");
		map.put("Banana", "바나나");
		map.put("Melon", "멜론");
		map.put("Podo", "포도");
		
		System.out.print("영어 단어를 입력하세요 >> ");
		String answer = sc.next();
		
		System.out.println(answer + " = Eng <-> Kor = " + map.get(answer));
		
	}

}
