package chapter03;

public class MethodExample {
	public static int add3(int n) {
		int result = n + 3;
		return result;
	}

	public static void main(String[] args) {
		int a = add3(10);
		System.out.println(a);
	}
}
