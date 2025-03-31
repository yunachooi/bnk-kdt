package chapter05_vo;

public class CalcArea{
	public static void ClacArea(Shape shape) { // 의존성이 줄어들고, 타입의 유연성은 올라감.
		if(shape instanceof Ractangle) {
			Ractangle r = (Ractangle)shape;
			System.out.println(r.name + "의 면적은 " + (r.weight * r.height) + "cm입니다.");
		}
		else if(shape instanceof Triangle) {
			Triangle t = (Triangle)shape;
			System.out.println(t.name + "의 면적은 " + ((t.height * t.base) / 2) + "cm입니다.");
		}
		else if(shape instanceof Cercle) {
			Cercle c = (Cercle)shape;
			System.out.println(c.name + "의 면적은 " + (c.r * c.r * 3.14) + "cm입니다.");
		}
	}
}