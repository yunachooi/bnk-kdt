package week_01;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 값이 있는 배열을 생성 후 a 배열과 b 배열에 값을 홀수, 짝수로 변경
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] a = new int[5];
		int[] b = new int[5];
		int aidx = 0;
		int bidx = 0;
		
		
		for (int i = 0; i < 5; i++) {
			a[i] = 0;
			b[i] = 0;
		}

		for (int i = 0; i < 10; i++) {
			if (arr[i] % 2 == 0) {
				a[aidx] = arr[i];
				aidx = aidx + 1;
			}
			else {
				b[bidx] = arr[i];
				bidx = bidx + 1;
			}
		}
		
		System.out.print("짝수 = ");
		for (int i = 0; i < 5; i++) {
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
		
		System.out.print("홀수 = ");
		for (int i = 0; i < 5; i++) {
			System.out.print(b[i] + " ");
		}
	}

}