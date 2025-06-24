package chapter11;

import chapter11_vo.InfiniteGenericsArray;

public class InfiniteArray2 {
	
	public static void main(String[] args) {
		InfiniteGenericsArray<String> stringList = new InfiniteGenericsArray<String>();
		stringList.add("hello");
		stringList.add("java");
		stringList.add("hello");
		stringList.add("java");
		System.out.println(stringList.toString());
		
		stringList.remove(0);
		System.out.println(stringList.toString());
		stringList.search(0);
		System.out.println("배열의 길이 : " + stringList.arraySize());
		
		
		
		
		InfiniteGenericsArray<Integer> intList = new InfiniteGenericsArray<Integer>();
		intList.add(1);
//		intList.add("hello");
		System.out.println(intList.toString());
		
		intList.remove(0);
		System.out.println(intList.toString());
		intList.search(0);
		System.out.println("배열의 길이 : " + intList.arraySize());
	}
	
	
}