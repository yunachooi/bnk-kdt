package chapter05_vo;

public class MyCharArray {
	private char[] arr;
	private char[] temp;
	static int point = 4;
	int cnt;

	public MyCharArray() {
		this.arr = new char[5];
	}

	public void inputChar(int idx, char n) {
		arr[idx] = n;
	}

	public int outPutChar(int idx) {
		return arr[idx];
	}

	public void removeChar(int idx) {
		for (int i = idx; i < point; i++) {
			arr[i] = arr[i + 1];
		}
		point -= 1;
	}

	public void removeAll() {
		point = -1;
		System.out.println("모든 배열을 삭제하였습니다...");
	}

	public void addChar(char n) {
		// 늘어나는 배열 생성
		if (point >= arr.length - 1) {
			temp = new char[arr.length + 5];
			for (int i = 0; i < arr.length; i++) {
				temp[i] = arr[i];
			}
			arr = temp;
		}

		arr[point + 1] = n;
		point += 1;
	}

	public void inarrChar(char n) {
		cnt = 0;
		for (int i = 0; i < point + 1; i++) {
			if (arr[i] == n) {
				cnt++;
			}
		}
		if (cnt != 0) {
			System.out.println("배열 안에 " + n +"값이 존재합니다...");
		} else {
			System.out.println("배열 안에 " + n +"값이 존재하지않습니다...");
		}
	}

	public void arrlength() {
		System.out.println("현재 유효한 배열의 길이는 " + (point + 1) + "입니다...");
	}

	public void showInfo() {
		System.out.print("배열 >> [ ");
		for (int i = 0; i < point + 1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("]\n");
	}
}
