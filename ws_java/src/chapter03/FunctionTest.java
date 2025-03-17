package chapter03;

public class FunctionTest {

	// 덧셈, 뺄셈, 곱셈, 나눗셈 함수를 만들어서 출력하기
	public static int sum(int a, int b){
		return a + b;
	}
	public static int sub(int a, int b) {
		return a - b;
	}
	public static int mul(int a, int b) {
		return a * b;
	}
	public static double div(int a, int b) {
		return (double)a / b;
	}
	
	public static void main(String[] args) {
		System.out.println("a = 10, b = 5");
		System.out.println("--------------");
		
		System.out.println("sum >> " + sum(10, 5));
		System.out.println("subtraction >> " + sub(10, 5));
		System.out.println("multiplication >> " + mul(10, 5));
		System.out.println("division >> " + div(10, 5));
	}

}