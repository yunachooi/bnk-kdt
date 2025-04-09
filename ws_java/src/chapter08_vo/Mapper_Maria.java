package chapter08_vo;

import java.util.ArrayList;
import java.util.List;

public class Mapper_Maria implements IMapper_crud {
	@Override
	public void create(Member member) {
		System.out.println("마리아로 멤버 등록!");
	}

	@Override
	public List<Member> readAll() {
		List<Member> list = new ArrayList<>();
		return list;
	}

	@Override
	public Member read(int mno) {
		Member member = new Member();
		return member;
	}
}
