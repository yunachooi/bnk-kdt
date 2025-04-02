package chapter05;

import chapter05_vo.Animal;
import chapter05_vo.Cat;
import chapter05_vo.Dog;
import chapter05_vo.Tiger;

public class ExtendsAnimal {

	public static void main(String[] args) {
		Animal[] animal = new Animal[3];
		
		Cat cat = new Cat();
		Dog dog = new Dog();
		Tiger tiger = new Tiger();
		
		animal[0] = cat;
		animal[1] = dog;
		animal[2] = tiger;

		for (int i = 0; i < 3; i++) {
			animal[i].cry();
		}
	}

}
