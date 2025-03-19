package chapter03;

public class SwapNumber {
	
	public static void f(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static int[] f2(int[] A) {
		int temp = A[0];
		A[0] = A[1];
		A[1] = temp;
		
		return A;
	}

	public static void main(String[] args) {
		int n1 = 5;
		int n2 = 3;
		
		System.out.printf("f 함수 실행 전 : %d, %d\n", n1, n2);
		f(n1, n2);
		System.out.printf("f 함수 실행 후 : %d, %d\n", n1, n2);
		
		System.out.println("-----------------");
		
		int A[] = new int[2];
		A[0] = 5;
		A[1] = 3;
		
		System.out.printf("f2 함수 실행 전 : %d, %d\n", A[0], A[1]);
		f2(A);
		System.out.printf("f2 함수 실행 후 : %d, %d\n", A[0], A[1]);
		
	}

}