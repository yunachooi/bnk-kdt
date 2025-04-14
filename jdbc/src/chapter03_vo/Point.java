package chapter03_vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Point implements Cloneable{
	private int xPos;
	private int yPos;
	
	public Point(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void showPosition() {
		System.out.printf("[%d, %d]", xPos, yPos);
		System.out.println();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException { //상속관계에서 접근가능.
		return (Point) super.clone();
	}

	public void changePos(int x, int y) {
		this.xPos = y;
		this.yPos = x;
	}
}
