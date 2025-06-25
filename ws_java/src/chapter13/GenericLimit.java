package chapter13;

import java.util.ArrayList;
import java.util.List;

class Animal {

}

class Dog extends Animal {

}

class Cat extends Animal {

}

class SubDog extends Dog {

}

public class GenericLimit {
	public static void main(String[] args) {
		/* 제네릭
		 * 하한 제한(super): 어떤 타입의 이상만 가능 -- <? super T> -- T 타입 이상
		 * 상향 제한(extends): 어떤 타입의 이하만 가능 -- <? extends T> -- T 타입 이하
		 * super: 쓰기 전용 함수 -- 제한 문법
		 * extends: 읽기 전용 함수 -- 제한 문법
		 * */
		
		List<? super Dog> list1 = new ArrayList<Dog>();
		List<? super Dog> list2 = new ArrayList<Animal>();
		List<? super Dog> list3 = new ArrayList<Object>();
//		List<? super Dog> list4 = new ArrayList<SubDog>(); 불가능
		
		List<? extends Dog> list5 = new ArrayList<Dog>();
		List<? extends Dog> list6 = new ArrayList<SubDog>();
//		List<? extends Dog> list7 = new ArrayList<Animal>(); 불가능
	}
	
	public static void underLimit(List<? super Dog> list) {
		Dog dog = new Dog();
		list.add(dog);
		
//		Dog d = list.get(0); 불가능
		Object obj = list.get(0);
	}
	
	public static void topLimit(List<? extends Dog> list) {
		Dog dog = list.get(0);
		
//		list.add(dog); 불가능
	}
}