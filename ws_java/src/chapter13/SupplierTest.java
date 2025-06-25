package chapter13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		/* Supplier: T 타입의 자료를 반환한다. - get()
		 * 
		 * IntSupplier : int getAsInt()
		 * LongSupplier : long getAsLong()
		 * DoubleSupplier : double getAsDouble()
		 * BooleanSupplier : boolean getAsBoolean()
		 * */
		Supplier<Integer> makeNumber = () -> {
			Random random = new Random();
			return random.nextInt(10);
		};
		
		int rdNum = makeNumber.get();
		System.out.println(rdNum);
		
		List<Integer> list = makeIntList(makeNumber, 5);
		
		for (int num : list) {
		    System.out.print(num + " ");
		}
	}
	
	public static List<Integer> makeIntList(Supplier<Integer> mkNum, Integer n){
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(mkNum.get());
		}
		
		return list;
	}
}
