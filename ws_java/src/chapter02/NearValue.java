package chapter02;

public class NearValue {

	public static void main(String[] args) {
	
	// 배열 요소 7과 가까운 요소(값)와 위치 출력
	int[] arr = new int[] {21, 8, 9, 15, 42, 35, 19, 1, 12, 27};
	int near = 0;
	int near_i = 0;
	int min = 100;
	
	for (int i = 0; i < 10; i++) {
		if (arr[i] <= 7) {
			near = 7 - arr[i];
		}
		else {
			near = arr[i] - 7;
		}
		
		if (near < min) {
			min = near;
			near_i = i;
		}
	}
	
	System.out.println("가까운 요소 : " + arr[near_i]);
	System.out.println("위치 : " + (near_i + 1));
	}

}
