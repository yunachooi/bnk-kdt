package chapter03;

public class HiphonPrint {
	public static void lineprint(int a) {
		for(int i = 0; i < a; i++) {
			System.out.print("-");
		}
		
		System.out.println();
	}
	
	public static void lineprint2(int a, char b) {
		for(int i = 0; i < a; i++) {
			System.out.print(b);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		lineprint(10);
		lineprint(20);
		lineprint2(30, '*');
	}

}
