package chapter03;

public class RepeatChar {

	public static void f(int a, char b){
		for(int i = 1; i <= a; i++) {
			if(i % 5 == 0) {
				System.out.print('B');
			}
			else {
				System.out.print(b);
			}
		}
		System.out.println();
		System.out.println();
	}
	
	public static void main(String[] args) {
		int n = 20;
		char x = 'A';
		
		f(n, x);
		
		System.out.println("----End----");
	}

}
