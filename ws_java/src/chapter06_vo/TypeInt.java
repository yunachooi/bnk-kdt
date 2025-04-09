package chapter06_vo;

public class TypeInt extends DataType implements ISample {
	public int n;
	public TypeString s;
	
	//방법1
	public TypeInt() {
		//s = new TypeString();
	}
	//방법2
	public void setS(TypeString s) {
		//클래스 외부에서 자료가 넘어옴.
		this.s = s;
	}
}
