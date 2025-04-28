package chapter07.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/* VO는 변하지 않는 값 자체, 데이터를 저장하는 용도(setter 미존재) */
/* DTO는 계층 간 데이터 전달(이동, 전송용, setter 존재) */

@Setter /* grade 때문에 필요*/
@Getter
@AllArgsConstructor /* 모든 필드를 매개변수로 받는 생성자 자동 생성 */
@ToString
public class MemberDTO {
	private final String id;
	private final String pw;
	private final String name;
	private final String phone;
	private String grade;
}
