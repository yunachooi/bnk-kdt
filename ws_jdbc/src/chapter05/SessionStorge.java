package chapter05;

import java.util.HashMap;
import java.util.Map;

public class SessionStorge {
	private static Integer userid;

	public void loginid(int id) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, id);

		userid = map.get(1);
	}

	public void logout() {
		userid = null;
	}

	public Integer getUserid() {
		return userid;
	}

}
