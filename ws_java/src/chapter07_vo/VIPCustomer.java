package chapter07_vo;

public class VIPCustomer extends Customer implements VipService{

	private static int vcnt = 1;
	private String vno;
	private double point;
	
	public VIPCustomer(Customer customer) {
		//protected 는 상속 관계에서 private을 geter, seter 없이 사용 가능하도록 도움.
		super(customer.cno, customer.name, customer.phone, customer.payment);
		vno = "v" + vcnt++;
	}

	public String getVno() {
		return vno;
	}
	
	@Override
	public void savePoint(int cost) {
		point = point + (double)cost * (5/100);
	}

	@Override
	public String toString() {
		return "VIPCustomer [vno=" + vno + ", point=" + point + ", cno=" + cno + ", name=" + name + ", phone=" + phone
				+ ", payment=" + payment + "]";
	}

}
