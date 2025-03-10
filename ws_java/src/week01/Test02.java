package week01;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1부터 10까지 누계
		int sum = 0;
				
		for (int i = 0; i <= 10; i++) {
			sum = sum + i;
		}
		
		System.out.println(sum);
				
				
		// 1부터 100까지 홀수 누계
		int sum2 = 0;
				
		for (int i = 1; i < 100; i = i + 2) {
			sum2 = sum2 + i;
		}
				
		System.out.println(sum2);
				
				
		// 1/2 + 2/3 + 4/3 ... 49/50 분수의 누계
		float sum3 = 0;
		float n = 1;

		while (n < 50) {
			sum3 = sum3 + (n / (n + 1));
			n += 1;
		}
				
		System.out.printf("%.2f\n", sum3);
		
		
		// arr 배열 생성 후 1 ~ 10의 값 저장 1
		int[] arr = new int[10];
		
		for (int i = 0; i < 10; i ++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n---------------------");
		
		
		// arr 배열 생성 후 1 ~ 10의 값 저장 2
		int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		for (int i = 0; i < 10; i ++) {
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
