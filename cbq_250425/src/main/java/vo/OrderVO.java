package vo;

import lombok.Data;

@Data
public class OrderVO {
	private String orderno;
	private String shopno;
	private String orderdate;
	private String pcode;
	private int amount;
}
