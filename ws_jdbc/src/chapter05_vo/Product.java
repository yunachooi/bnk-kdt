package chapter05_vo;

import lombok.Data;

@Data
public class Product {
	private String p_code;
	private String p_name;
	private int p_cost;
	private String p_group;
}
