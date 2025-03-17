package chapter03;

public class CalculatorFunction {
	public static int sum(int a, int b) {
		return a + b;
	}
	public static int sub(int a, int b) {
		return a - b;
	}
	public static int mul(int a, int b) {
		return a * b;
	}
	public static double div(int a, int b) {
		return (double) a / b;
	}

	public static void calculator(int a, int b) {
		System.out.println("sum >> " + sum(a, b));
		System.out.println("subtraction >> " + sub(a, b));
		System.out.println("multiplication >> " + mul(a, b));
		System.out.println("division >> " + div(a, b));
	}

	public static void main(String[] args) {
		System.out.println("a = 10, b = 5");
		System.out.println("-------------");

		calculator(10, 5);

		System.out.println("-------------");
		System.out.println("프로그램을 종료합니다...");
	}

}