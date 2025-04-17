package chapter05_vo;

import lombok.Data;

@Data
public class Employee {
	private int e_no;
	private String e_pw;
	private String e_name;
	private String e_pos;
	private String e_dept;
	private String e_date;
}
