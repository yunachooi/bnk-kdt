package chapter13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;

public class LottoNum {
	public static void main(String[] args) {
		Supplier<Integer> makeNumber = () -> {
			Random random = new Random();
			return random.nextInt(45) + 1;
		};
		
		System.out.println("로또 추첨 번호(List): " + makeLottoList(makeNumber, 6));
		System.out.println("로또 추첨 번호(Set): " + makeLottoSet(makeNumber, 6));
	}
	
	//방법 1 - List, contains
	public static List<Integer> makeLottoList(Supplier<Integer> mkNum, Integer n){
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			boolean flag = true;
			while(flag) {
				Integer num = mkNum.get();
				
				if(!list.contains(num)) {
					list.add(num);
					flag = false;
				}
			}
		}
		
		return list;
	}
	
	//방법 2 - Set
	public static Set<Integer> makeLottoSet(Supplier<Integer> mkNum, int n) {
        Set<Integer> lottoSet = new HashSet<>();
        
        while (lottoSet.size() < n) {
            lottoSet.add(mkNum.get());
        }
        
        return lottoSet;
    }
}
