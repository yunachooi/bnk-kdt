package chapter02;

public class Carculater {

	public static void main(String[] args) {
		//vo는 필수적으로 해야하는 작업으로 getter, setter를 사용
		//dto는 전달하는 용도이므로 값이 변하면 안됨.(상수:final)
		
		Carc2 c = new Carc2();
		
		System.out.println("SUM >> " + c.sum(5, 5));
		System.out.println("MINUS >> " + c.minus(5, 5));
		System.out.println("MUL >> " + c.mul(5, 5));
		System.out.println("DIV >> " + c.div(5, 5));
		System.out.println("ABS >> " + c.abs(-5));
		System.out.println("POWER >> " + c.power(5));
	}
	
	
}