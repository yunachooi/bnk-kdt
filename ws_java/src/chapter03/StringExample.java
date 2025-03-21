package chapter03;

public class StringExample {

	public static void main(String[] args) {
		String str = "Java is easy";
		System.out.println(str);
		
		char[] temp = new char[str.length()];
		System.out.println(temp.length);
		
		temp[0] = str.charAt(0);
		System.out.println(temp[0]);
	}

}
