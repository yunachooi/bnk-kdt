package chapter11_vo;

import java.util.Arrays;

public class InfiniteGenericsArray<T> {
	private T[] A = (T[]) new Object[3];
	private T[] B;
	private int n = 0;
	
	public void add(T num) {
		A[n] = num;
		n++;
		
		if(n == A.length) {
			infinityB();
		}
	}
	
	public void remove(int num) {
		for(int i = num; i < A.length - 1; i++) {
			A[i] = A[i + 1];
		}
	}
	
	public void search(int num) {
		System.out.println("배열의 " + num + "번째 값 : " + A[num]);
	}
	
	public void infinityB() {
		B = (T[]) new Object[A.length + 1];
		for(int i = 0; i < A.length; i++) {
			B[i] = A[i];
		}
		A = B;
	}
	
	public int arraySize() {
		return A.length;
	}

	@Override
	public String toString() {
		return "ArrayList [A=" + Arrays.toString(A) + "]";
	}
}
