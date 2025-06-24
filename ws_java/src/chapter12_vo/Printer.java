package chapter12_vo;

public class Printer implements Printable{
	@Override
    public void print(String s) {
        System.out.println(s);
    }
}
