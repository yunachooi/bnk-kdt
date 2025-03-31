package chapter05;

import chapter05_vo.CalcArea;
import chapter05_vo.Cercle;
import chapter05_vo.Ractangle;
import chapter05_vo.Shape;
import chapter05_vo.Triangle;

public class ExtendsShape {

	public static void main(String[] args) {
		Shape[] shape = new Shape[3];
		
		Ractangle ractangle = new Ractangle("사각형");
		Triangle triangle = new Triangle("삼각형");
		Cercle cercle = new Cercle("원");
		
		shape[0] = ractangle;
		shape[1] = triangle;
		shape[2] = cercle;
		
		for(int i = 0; i < 3; i++) {
			CalcArea.ClacArea(shape[i]);
		}
	}

}
