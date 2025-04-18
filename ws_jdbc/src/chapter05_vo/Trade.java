package chapter05_vo;

import lombok.Data;

@Data
public class Trade {
	private String t_seq;
	private String t_date;
	private int t_qty;
	private int t_cost;
	private String p_code;
	private String c_code;
}
