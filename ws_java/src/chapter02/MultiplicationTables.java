package chapter02;

public class MultiplicationTables {

	public static void main(String[] args) {
		//중첩 반복문
		for(int i = 0; i < 3; i ++) {
			System.out.println("...바깥 쪽 반복문 실행 >> " + (i + 1));
			for (int k = 0; k < 5; k++) {
				System.out.println("\t안 쪽 반복문 실행... >> " + (k + 1));
			}
			System.out.println();
		}
		
		// 구구단 ver.1 (세로)
		for(int i = 1; i < 10; i++) {
			System.out.println(i + "단을 외우자!");
			for (int j = 1; j < 10; j++) {
				System.out.println(i + " * " +  j + " = " + (i * j) + "\t");
			}
			System.out.println();
		}
		
		// 구구단 ver.2 (가로)
		for (int i = 1; i < 10; i ++) {
			System.out.print(i + "단을 외우자!\t");
		}
		for (int i = 1; i < 10; i ++) {
			System.out.println();
			for (int j = 1; j < 10; j++) {
				System.out.print(j + " * " + i  + " = " + (i * j) + "\t");
			}
		}
	}
	
}