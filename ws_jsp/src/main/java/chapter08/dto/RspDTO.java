package chapter08.dto;

import lombok.Data;

@Data
public class RspDTO {
	private String id;
	private String pw;
	private int win;
	private int lose;
	private int draw;
}
