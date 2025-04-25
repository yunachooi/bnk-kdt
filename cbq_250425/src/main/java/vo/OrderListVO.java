package vo;

import lombok.Data;

@Data
public class OrderListVO {
	private String shopno;
	private String shopname;
	private String orderno;
	private String orderdate;
	private String pcode;
	private String pname;
	private int amount;
	private String cost;
	private String cprice;
	private String dprice;
}
