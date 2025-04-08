package chapter06;

import chapter06_vo.DataType;
import chapter06_vo.ISample;
import chapter06_vo.TypeFloat;
import chapter06_vo.TypeInt;
import chapter06_vo.TypeObject;
import chapter06_vo.TypeString;
import chapter06_vo.TypeZeneric;

public class TypeTest {

	public static void main(String[] args) {
		TypeInt ti = new TypeInt();
		TypeFloat tf = new TypeFloat();
		TypeString ts = new TypeString();
		
		TypeInt[] tiArr = new TypeInt[3];
		tiArr[0] = ti;
		//tiArr[1] = tf; 타입이 같지 않아서 사용할 수 없음. -> 상속사용.
		//tiArr[2] = ts;
		
		//함수의 매개변수에서 주로 사용됨.
		DataType[] dtArr = new DataType[3];
		dtArr[0] = ti;
		dtArr[1] = tf;
		dtArr[2] = ts;
		
		ti.n = 10;
		ti.setS(ts);
		ti.s.s = "hello";
		System.out.println(ti.n);
		System.out.println(ti.s.s);
		
		f(ti);
		f(tf);
		f(ts);
		
		/* Object */
		TypeObject to = new TypeObject();
		to.obj = new TypeInt();
		to.obj = tf;
		// to.obj.f 부모타입의 참조변수로는 자식의 고유의 데이터에 접근이 불가.
		TypeFloat x = (TypeFloat)to.obj;
		x.f = 10.7f;
		System.out.println(x.f);
		
		
		/* Zeneric */
		TypeZeneric <TypeFloat> tzrString = new TypeZeneric<>();
		tzrString.t = tf;
		tzrString.t.f = 10.7f;
		System.out.println(tzrString.t.f);
	}
	
	public static void f(DataType s) {
		
	}
	
	public static void f2(ISample s) {
		//상속과 같은 방식으로 돌아감. 다중상속의 개념.
		//타입의 유연성
	}

}