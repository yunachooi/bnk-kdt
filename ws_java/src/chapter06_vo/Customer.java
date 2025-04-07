package chapter06_vo;

public class Customer {
	static int no = 1;
	String custom_no;
	String name;
	String phone;
	int purchase;
	double point;
	
	public Customer(String name, String phone, int purchase) {
		this.name = name;
		this.phone = phone;
		this.purchase = purchase;
		
		if(purchase >= 1000000) {
			System.out.println("VIP 고객으로 전환되었습니다.");
			custom_no = "v" + no;
			point = purchase * 0.05;
		}
		else {
			custom_no = "c" + no;
		}
		no = no + 1;
		System.out.println(toString());
		
	}

	@Override
	public String toString() {
		return "Customer [custom_no=" + custom_no + ", name=" + name + ", phone=" + phone + ", purchase=" + purchase
				+ ", point=" + point + "]";
	}
	

	
	
}
