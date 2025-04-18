package chapter04;

import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) throws IOException {
		try {
			FileWriter fw = new FileWriter("C:/Temp/jv_test/test.txt");
			fw.write("Hello, Java File I/O 연습중입니다.");
			fw.close();
//			
			fw = new FileWriter("C:/Temp/jv_test/test.txt", true); // 이어쓰기
//			fw = new FileWriter("C:/Temp/jv_test/test.txt"); //덮어쓰기
			fw.write("\n이어서 씁니다.Hello, Java File I/O를 연습중입니다.\n");
			fw.close();
			
			System.out.println("파일에 문자열을 성공적으로 썼습니다.");
		} catch(EOFException e) {
			e.printStackTrace();
		}
	}

}
