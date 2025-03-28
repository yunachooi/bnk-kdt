package chapter04_vo;

public class Static {
	public int n;
	public static int x;
	public static int y;
	
	public void nonStaticF() {
		test();
		staticF();
		System.out.println("f함수 실행...");
	}
	public static void staticF() {
		// test(); 호출 시 오류 발생
		System.out.println("static f함수 실행...");
	}
	
	void test(){
		System.out.println("test입니다...");
	}
}
