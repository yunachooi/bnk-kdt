package chapter02;

import java.util.Arrays;
import java.util.Random;

public class LottoNumber {

	public static void main(String[] args) {
		
		// 중복되지 않는 로또 번호 추출기
		int[] lotto = new int[6];
		Random rd = new Random();
		
		for(int i = 0; i < 6; i++) {
			int rdNum = rd.nextInt(45) + 1;
			lotto[i] = rdNum;
			
			for(int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
				}
			}
		}
		System.out.println(Arrays.toString(lotto));
	}

}
