package chapter04;

public class CalculaterTest {

	public static void main(String[] args) {
		Calculater cal = new Calculater();
		int a = 10;
		int b = 20;
		
		System.out.println("---Calculater---");
		cal.sum(a, b);
		cal.sub(a, b);
		cal.mul(a, b);
		cal.div(a, b);
	}

}
