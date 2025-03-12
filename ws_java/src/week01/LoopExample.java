package week01;

public class LoopExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 반복문 연습 (while문)
		int idx = 0;
		while (idx < 5) {
			System.out.println((idx + 1) + ") Hello!");
			idx ++;
		}
		System.out.println();
		
		
		// 반복문 연습 (for문)
		for (int idx2 = 0; idx2 < 5; idx2++) {
			System.out.println((idx2 + 1) + "- Hello");
		}
		System.out.println();

		
		// 배열 연습
		int[] arr = new int[5];
		
		for (int idx3 = 0; idx3 < 5; idx3++) {
			System.out.print(arr[idx3] + " -> ");
			arr[idx3] = idx3 + 1;
			System.out.println(arr[idx3]);
		}
		
		System.out.print("\narr[4] = " + arr[4] + " -> ");
		arr[4] = 100;
		System.out.println(arr[4]);
	}
}
