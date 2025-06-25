package chapter13;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest2 {
    public static void main(String[] args) {
    	/* Predicate<T>를 구체화한 인터페이스 틀
    	 * IntPredicate : boolean test(int value)
    	 * LongPredicate : boolean test(long value)
    	 * DoublePredicate : boolean test(double value)
    	 * BiPredicate<T, U> : boolean Test(T t, U u)
    	 * */
    	
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        Predicate<Integer> even = n -> n % 2 == 0;
        int evenSum = sum(even, list);
        System.out.println(evenSum);
        
        Predicate<Integer> odd = n -> n % 2 != 0;
        int oddSum = sum(odd, list);
        System.out.println(oddSum);
    }

    private static int sum(Predicate<Integer> p, List<Integer> list) {
        int sum = 0;
        
        for(Integer n : list) {
        	if(p.test(n)) {
        		sum += n;
        	}
        }
        
        return sum;
    }
}
