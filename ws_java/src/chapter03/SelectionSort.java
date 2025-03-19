package chapter03;

import java.util.Arrays;

public class SelectionSort {

	// 선택정렬
	public static void main(String[] args) {
		int[] arr = { 5, 6, 2, 1, 4, 3 };
		int temp = -1;

		for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j <arr.length; j++) {
            	if(arr[i] >= arr[j]) {
            		temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
            	}
            }
        }
		
		System.out.println(Arrays.toString(arr));

	}

}