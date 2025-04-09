package chapter07_vo;

public class Customer {

	private static int cnt = 1;
	protected String cno;
	protected String name;
	protected String phone;
	protected int payment;
	
	public Customer(String name, String phone) {
		cno = "c" + cnt++;
		this.name = name;
		this.phone = phone;
	}
	
	public Customer(String cno, String name, String phone, int payment) {
		this.cno = cno;
		this.name = name;
		this.phone = phone;
		this.payment = payment;
	}

	public String getCno() {
		return cno;
	}

//	public void setCno(String cno) {
//		this.cno = cno;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPayment() {
		return payment;
	}

	public Customer buy(int cost) {
		payment = payment + cost;
		if(payment > 1_000_000) {
			return CustomerManager.createVipCustomer(this);
		}
		return this;
	}
	
	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", name=" + name + ", phone=" + phone + ", payment=" + payment + "]";
	}
	
}
