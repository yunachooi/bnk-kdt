package chapter03;

public class LastFunction {
	static int param1 = 0, param2 = 0, param3 = 0, param4 = 0;
	
	public static int  f(int a) {
		int n = 10;
		param1 = a;
		return f2(n);
	}
	public static int f2(int a) {
		int n = 100;
		param2 = a;
		return f3(n);
	}
	public static int f3(int a) {
		int n = 1000;
		param3 = a;
		return f4(n);
	}
	public static int f4(int param4) {
		return param1 + param2 + param3 + param4;
	}

	public static void main(String[] args) {
		int n = 1;
		int result = f(n);
		System.out.println(result);
	}

}
