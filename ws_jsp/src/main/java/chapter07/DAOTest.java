package chapter07;

import chapter07.dao.MemberDAO;

public class DAOTest {
	public static void main(String[] args) {
		MemberDAO a = MemberDAO.getMemberDao();
		MemberDAO b = MemberDAO.getMemberDao();
		
		System.out.println(a == b);
	}
}
