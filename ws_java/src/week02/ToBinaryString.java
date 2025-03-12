package week02;

public class ToBinaryString {

	public static void main(String[] args) {
		
		// IEEE 754, 소수점 메모리 표기
		float f = 13.625f;
		int n = Float.floatToIntBits(f);
		
		System.out.println(Integer.toBinaryString(n));
		
		
		// 자료형 변환 (강제 변환)
		byte bNum = 127;
		byte bnum = -128;

		bNum = (byte)(bNum + 1);
		bnum = (byte)(bnum - 1);

		System.out.println("bNum = " + bNum);
		System.out.println("bnum = " + bnum);
		
		
		// 진수 표기 접두어
		int iN = 10;
		String binaryString = Integer.toBinaryString(iN);
		System.out.println("binaryString = " + binaryString);
		
		int in = 0b1010; // 2진수 = 0b
		System.out.println("2진수 = " + in);
		
		int in2 = 0017; // 8진수 = 0
		System.out.println("8진수 = " + in2);
		
		int in3 = 0xA5; // 16진수 = 0x
		System.out.println("16진수 = " + in3);
		
		
		// 시프트 연산자
		int nn = 1;
		
		System.out.println(nn << 1); // 비트 상에서 왼쪽으로 1칸 이동
		System.out.println(nn << 2);
		
		nn = -1;
		System.out.println(nn >> 1); // 비트 상에서 오른쪽으로 1칸 이동
	}

}
