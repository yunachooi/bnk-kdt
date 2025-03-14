package chapter02;

public class DoubleArraysExample {

	public static void main(String[] args) {
		int[][] arr = new int[3][5];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				arr[i][j] = 1;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}

}
