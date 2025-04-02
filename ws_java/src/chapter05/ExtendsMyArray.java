package chapter05;

import chapter05_vo.MyCharArray;
import chapter05_vo.MyIntArray;

public class ExtendsMyArray {

	public static void main(String[] args) {
		MyIntArray mia = new MyIntArray();
		MyCharArray mca = new MyCharArray();
		
		mia.inputInt(0, 0);
		mia.inputInt(1, 1);
		mia.inputInt(2, 2);
		mia.inputInt(3, 3);
		mia.inputInt(4, 4);
		
		mca.inputChar(0, 'a');
		mca.inputChar(1, 'b');
		mca.inputChar(2, 'c');
		mca.inputChar(3, 'd');
		mca.inputChar(4, 'e');
		
		mia.inarrInt(3);
		mca.inarrChar('c');
		
	
		mia.removeInt(1);
		mca.removeChar(1);
		mia.arrlength();
		mca.arrlength();
		
		mia.addInt(5);
		mca.addChar('g');
		mia.showInfo();
		mca.showInfo();
		
		mia.removeAll();
		mca.removeAll();
		
		
	}
}
