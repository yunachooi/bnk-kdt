package week02;

public class SwitchCaseExample {

	public static void main(String[] args) {

		// 정수 switch-case문
		int x = 1;

		switch (x) {
		case 1: System.out.println("1입니다."); break; // if
		case 2: System.out.println("2입니다."); break;
		case 3: System.out.println("3입니다."); break;
		default: System.out.println("1도 2도 3도 아닙니다."); break;// else
		}

		// 문자 switch-case문
		char c = 'A';

		switch (c) {
		case 'A': System.out.println("A입니다."); break; // if
		case 'B': System.out.println("B입니다."); break;
		case 'C': System.out.println("C입니다."); break;
		default: System.out.println("A도 B도 C도 아닙니다."); break;// else
		}
		
		// 아스키 코드 switch-case문
		char a = 'A';

		switch (a) {
		case 65: System.out.println("A입니다."); break; // if
		case 66: System.out.println("B입니다."); break;
		case 67: System.out.println("C입니다."); break;
		default: System.out.println("A도 B도 C도 아닙니다."); break;// else
		}
		
		// 문자열 switch-case문
		String s = "철수";

		switch (s) {
		case "철수" : System.out.println("철수입니다."); break; // if
		case "영희" : System.out.println("영희입니다."); break;
		case "숙이" : System.out.println("숙이입니다."); break;
		default: System.out.println("A도 B도 C도 아닙니다."); break;// else
		}
		
		
		char A = 'A';
		System.out.println((int)A);
	}

}
