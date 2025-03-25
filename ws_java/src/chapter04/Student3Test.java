package chapter04;

public class Student3Test {

	public static void main(String[] args) {
		Student3 s1 = new Student3(2, "ann", 'F');
		
		System.out.println("번호 >> " + s1.getNo());
		System.out.println("이름 >> " + s1.getName());
		System.out.println("성별 >> " + s1.getGender());
		System.out.println("-----------");

		s1.setNo(3);
		s1.setName("Ann");
		s1.setGender('M');
		
		System.out.println("변경된 번호 >> " + s1.no);
		System.out.println("변경된 이름 >> " + s1.name);
		System.out.println("변경된 성별 >> " + s1.gender);

	}

}
