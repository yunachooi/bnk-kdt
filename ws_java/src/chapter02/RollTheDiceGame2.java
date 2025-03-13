package chapter02;

import java.util.Random;

public class RollTheDiceGame2 {

	public static void main(String[] args) {
		Random rd = new Random();
		int rdNum = 0;
		int[] arr = new int[6];
		
		for (int i = 0; i < 100; i++) {
			rdNum = rd.nextInt(6) + 1;
			
			switch (rdNum) {
			case 1: arr[0] ++; break;
			case 2: arr[1] ++; break;
			case 3: arr[2] ++; break;
			case 4: arr[3] ++; break;
			case 5: arr[4] ++; break;
			default: arr[5] ++; break;
			}
		}
		
		for (int i = 0; i < 6; i++) {
			System.out.println((i + 1) + " >> " + arr[i]);
		}

	}
}