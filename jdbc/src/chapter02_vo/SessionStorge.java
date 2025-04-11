package chapter02_vo;

import java.util.HashMap;
import java.util.Map;

public class SessionStorge {
	private static String userid;

	public void loginid(String id) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, id);

		userid = map.get(1);
	}

	public void logout() {
		userid = null;
	}

	public String getUserid() {
		return userid;
	}

}
