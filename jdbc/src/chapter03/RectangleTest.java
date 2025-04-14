package chapter03;

import java.util.HashSet;

import chapter03_vo.Rectangle;

public class RectangleTest {

	public static void main(String[] args) {
		Rectangle org = new Rectangle(1, 1, 9, 9);
		Rectangle cpy = null;
		
		try {
			cpy = (Rectangle) org.clone();
			org.showPosition();
			cpy.showPosition();
			System.out.println("-----------");

			cpy.changePos(2, 2, 8, 8); // 참조변수는 clone 되지 않음. 동일한 객체를 지님. (얕은 복사 : 주소값만 복사 됨, 깊은 복사 : 주소 값과 내용이 함께 복사 됨)

			org.showPosition();
			cpy.showPosition();

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		HashSet<Rectangle> Llist = new HashSet<>();
		
		Llist.add(org);
		Llist.add(cpy);
		System.out.println("Llist2 size >> " + Llist.size());
	}

}
