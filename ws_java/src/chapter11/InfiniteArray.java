package chapter11;

import chapter11_vo.InfiniteIntArray;

public class InfiniteArray {
	
	public static void main(String[] args) {
		InfiniteIntArray list = new InfiniteIntArray();
		
		System.out.println(list.toString());
		
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		System.out.println(list.toString());
		
		list.remove(0);
		list.remove(0);
		System.out.println(list.toString());
		
		list.search(1);
		System.out.println("배열의 길이 : " + list.arraySize());
	}
	
	
}