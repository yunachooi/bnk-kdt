package chapter04;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	static FileReader fr;
	static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		try {
			fr = new FileReader("C:/Temp/jv_test/test.txt");
			
			int data = 0;
			//EOF : 파일의 끝은 -1
			while((data = fr.read()) != -1) {
				System.out.print((char) data);
			}
			fr.close();

			System.out.println("--버퍼 사용하기--");
			//문장 단위로 읽음
			//보조스트림이라 일컫는다.
			
			fr = new FileReader("C:/Temp/jv_test/test.txt");
			br = new BufferedReader(fr);
			
			String s = null;
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
			
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch(EOFException e) {
			e.printStackTrace();
		}
		
		
	}

}
