package chapter04;

public class Student2Test {

	public static void main(String[] args) {
		Student2 s1 = new Student2();
		Student2 s2 = new Student2(2, "ann", 'F');
		Student2 s3 = new Student2(3, "bread");

		System.out.println("번호 >> " + s1.no + "번");
		System.out.println("이름 >> " + s1.name);
		System.out.println("성별 >> " + s1.gender);
		System.out.println("-------------");

		System.out.println("번호 >> " + s2.no + "번");
		System.out.println("이름 >> " + s2.name);
		System.out.println("성별 >> " + s2.gender);
		System.out.println("-------------");

		System.out.println("번호 >> " + s3.no + "번");
		System.out.println("이름 >> " + s3.name);
		System.out.println("성별 >> " + s3.gender);
	}

}
