package chapter02;

public class NumberInsert {

	public static void main(String[] args) {

		int[][] arr = new int[5][5];
		int n = 1;
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(i % 2 == 0) {
					arr[i][j] = n;
					n += 1;
				}
				else{
					arr[i][4 - j] = n;
					n += 1;
				}
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
