package chapter05;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		// 동일한 문자열은 하나의 주소값을 공유해서 사용.
		// String 자료형에 할당된 문자열은 고정불변타입.
		// 문자열이 바뀌면 새로 만들어진걸로 주소가 변경됨.
		
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		
		// 참조 변수에서의 ==은 주소를 비교. (주소를 더 중요하게 여김)
		// .equals 는 문자의 내용을 비교. (내용을 더 중요하게 여김)
		// .equals 는 String 클래스의 멤버변수.
		// equalsIgnoreCase() 함수는 대소문자를 구분하지 않는다.
		System.out.println("== 사용 >> " + s1 == s2); // true
		System.out.println("== 사용 >> " + s1 == s3); // false
		System.out.println("equals 사용 >> " + s1.equals(s3)); // true
		System.out.println("equalsIgnoreCase 사용 >> " + s1.equalsIgnoreCase(s3));
		
		// charAt(위치) 함수는 String(문자열을)을 배열처럼 인식해서 인덱스로 처리.
		// 배열은 배열이 가진 속성값을 이용하여 길이를 확인.
		char c = s1.charAt(1);
		System.out.println("charAt 사용 >> " + c);
		
		char[] arr = new char[s1.length()];
		for(int i = 0; i < 5; i++) {
			arr[i] = s1.charAt(i);
		}
		System.out.println("charAt 사용 >> " + Arrays.toString(arr));
		
		// substring() 함수는 원하는 범위의 값을 지정하여 출력 가능.
		System.out.println("substring 사용 >> " + s1.substring(2));
		System.out.println("substring 사용 >> " + s1.substring(1, 2));
		
		// contains() 함수는 문자열을 포함하는지 여부 파악. (true, false)
		System.out.println("contains 사용 >> " + s1.contains("ll"));
		
		// indexOf() 함수는 int 타입으로 반환하고, 시작 인덱스를 반환.
		System.out.println("indexOf 사용 >> " + s1.indexOf("lo"));
		
		// 모두 대,소문자로 변경. (원본은 그대로 존재)
		System.out.println("toUpperCase 사용 >> " + s1.toUpperCase()); // 대문자
		System.out.println("toLowerCasee 사용 >> " + s1.toLowerCase()); // 소문자
		
		// trim() 함수는 공백을 제거.
		String s4 = "    Hello";
		System.out.println("trim 사용 >> " + s4.trim());
		
		// replace() 함수는 1번째 파라미터(인수)를 2번째 파라미터(인수)로 변경.
		System.out.println("replace 사용 >> " + s1.replace('H', 'h'));
		
		// split()
		String s5 = "aaa,bbb,ccc,ddd";
		String[] arr2 = s5.split(",");
		System.out.println("split 사용 >> " + Arrays.toString(arr2));
	}
	

}
