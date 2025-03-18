package chapter03;

public class ArraryFunction {
	public static int[] f1(int a, int b) {
		int arr[] = new int[2];
		arr[0] = a + b;
		arr[1] = a - b;
		
		return arr;
	}

	public static void main(String[] args) {
		int n1 = 10;
		int n2 = 20;
		
		System.out.println("두 수의 합 >> " + f1(n1, n2)[0]);
		System.out.println("두 수의 차 >> " + f1(n1, n2)[1]);
	}

}