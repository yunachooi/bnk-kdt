package chapter02;

import java.util.Random;

public class RollTheDiceGame {

	public static void main(String[] args) {
		// 주사위 백 번 굴리기 게임
		Random rd = new Random();
		int[] arr = new int[100];

		for (int i = 0; i < 100; i++) {
			int rdNum = rd.nextInt(6) + 1;
			arr[rdNum - 1]++;
		}

		for (int i = 0; i < 6; i++) {
			System.out.println((i + 1) + " >> " + arr[i] + "\t");
		}
	}

}