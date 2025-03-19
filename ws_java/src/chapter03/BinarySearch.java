package chapter03;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		int start = 0, mid = 0;
		int end = arr.length - 1;
		
		System.out.print("숫자를 입력하세요 >> ");
		int n = sc.nextInt();
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(arr[mid] < n) {
				start = mid + 1;
			}
			else if(arr[mid] > n) {
				end = mid - 1;
			}
			else {
				System.out.println(n + "은 " + (mid + 1) + "번 째에 위치해 있습니다.");
				break;
			}
		}
	}

}
