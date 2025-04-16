package chapter03_vo;

import lombok.Data;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode

@Data
public class Member {
	private int mno;
	private String name;
	private String phone;
	
//	@EqualsAndHashCode
//	@Override
//	public boolean equals(Object obj) {
//		if(this == obj) {
//			return true;
//		}
//		if(obj == null || getClass() != obj.getClass()) {
//			return false;
//		}
//		Member taget = (Member) obj;
//		if(mno == taget.mno && name == taget.name && phone == taget.phone) {
//			return true;
//		}
//		return false;
//	}
//	
//	@Override
//	public int hashCode() {
//		return Objects.hash(mno, name, phone);
//	}
	
}
