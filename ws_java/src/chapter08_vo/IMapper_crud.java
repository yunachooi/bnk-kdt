package chapter08_vo;

import java.util.List;

public interface IMapper_crud {
	public void create(Member member);
	public List<Member> readAll();
	public Member read(int mno);
}
