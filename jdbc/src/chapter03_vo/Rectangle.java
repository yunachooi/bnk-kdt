package chapter03_vo;

public class Rectangle implements Cloneable{
	private Point upperLeft;
	private Point lowerRight;
	
	public Rectangle(int x1, int y1, int x2, int y2) {
		upperLeft = new Point(x1, y1);
		lowerRight = new Point(x2, y2);
	}
	public void changePos(int x1, int y1, int x2, int y2) {
		upperLeft.changePos(x1, y1);
		lowerRight.changePos(x2, y2);
	}
	public void showPosition() {
		System.out.print("좌측 상단 : ");
		upperLeft.showPosition();
		
		System.out.print("우측 상단 : ");
		lowerRight.showPosition();
		System.out.println();
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Rectangle) super.clone();
	}
}
