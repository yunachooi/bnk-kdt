package chapter03;

public class SumFunction {
	public static int f(int n, int m, int k) {
		int[] A = new int[3];
		
		A[0] = n;
		A[1] = m;
		A[2] = k;
		
		int sum = A[0] + A[1] + A[2];
		
		return sum;
	}

	public static void main(String[] args) {
		int n = 5, m = 10,  k = 20;
		
		int sum = f(n, m, k);
		
		System.out.println("sum >> " + sum);
	}

}
