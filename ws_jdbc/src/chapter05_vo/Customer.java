package chapter05_vo;

import lombok.Data;

@Data
public class Customer {
	private String c_code;
	private String c_name;
	private String c_ceo;
	private String c_addre;
	private String c_phone;
}