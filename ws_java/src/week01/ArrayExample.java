package week01;

public class ArrayExample {

	public static void main(String[] args) {
		// arr 배열 생성 후 1 ~ 10의 값 저장 1
		int[] arr = new int[10];

		for (int i = 0; i < 10; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n---------------------");

		// arr 배열 생성 후 1 ~ 10의 값 저장 2
		int[] arr1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int i = 0; i < 10; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println("\n---------------------");

		// arr 배열에 5번째 값을 100으로 변경하기
		int[] arr2 = new int[10];

		for (int i = 0; i < 10; i++) {
			arr2[i] = i + 1;
		}

		arr2[4] = 100;

		for (int i = 0; i < 10; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println("\n---------------------");

		// brr 배열에 모든 값을 0으로 초기화하기
		int[] brr = new int[10];

		for (int i = 0; i < 10; i++) {
			brr[i] = 0;
			System.out.print(brr[i] + " ");
		}
		System.out.println("\n---------------------");

		// arr 배열에 1 ~ 10까지 저장 후 5번째 배열을 100으로 바꾸고, brr 배열에 역순으로 저장.
		int[] arr3 = new int[10];
		int[] brr2 = new int[10];

		for (int i = 0; i < 10; i++) {
			arr3[i] = i + 1;
		}

		arr3[4] = 100;

		for (int i = 0; i < 10; i++) {
			brr2[i] = arr3[9 - i];
			System.out.print(brr2[i] + " ");
		}

		System.out.println("\n---------------------");
	}

}
