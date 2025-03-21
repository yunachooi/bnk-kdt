package chapter03;

import java.util.Scanner;

public class BinaryConversion {
	public static void hexadecimal(int n) {
		int[] arr = new int[1000];
		int rest = 0, cnt = 0;
		int div = n;
		
		while(div >= 1) {
			div = n / 16;
			rest = n % 16;
			n = div;
			
			if(rest > 9) {
				switch(rest) {
				case 10 : rest = 65; break; 
				case 11 : rest = 66; break; 
				case 12 : rest = 67; break; 
				case 13 : rest = 68; break; 
				case 14 : rest = 69; break;
				default : rest = 70; break; 
				}
			}

			arr[cnt] = rest;
			cnt += 1;
		}
		
		System.out.print("16진수로 변환한 값 >> ");
		for(int i = cnt - 1; i >= 0; i--) {
			if(arr[i] >= 65) {
				System.out.print((char)arr[i]);
			}
			else {
				System.out.print(arr[i]);
			}
		}
		System.out.println("⒂");
	}
	
	public static void octal(int n) {
		int[] arr = new int[1000];
		int rest = 0, cnt = 0;
		int div = n;
		
		while(div >= 1) {
			div = n / 8;
			rest = n % 8;
			n = div;

			arr[cnt] = rest;
			cnt += 1;
		}
		
		System.out.print("8진수로 변환한 값 >> ");
		for(int i = cnt - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
		System.out.println("⑻");
	}
	
	public static void binary(int n) {
		int[] arr = new int[1000];
		int rest = 0, cnt = 0;
		int div = n;
		
		while(div >= 1) {
			div = n / 2;
			rest = n % 2;
			n = div;

			arr[cnt] = rest;
			cnt += 1;
		}
		
		System.out.print("2진수로 변환한 값 >> ");
		for(int i = cnt - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
		System.out.println("⑵");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("10진수를 입력하세요 >> ");
		int n = sc.nextInt();
		
		binary(n);
		octal(n);
		hexadecimal(n);
	}
}
