package es.upm.miw.apaw.p2.sport.wrappers;

import java.util.ArrayList;
import java.util.List;

public class UserNickListWrapper {
	List<UserNickWrapper> userList;

	
	public UserNickListWrapper() {
	    userList = new ArrayList<>();
	}

	public List<UserNickWrapper> getUserList() {
		return userList;
	}

	public void addUserNickWrapper(UserNickWrapper userWrapper){
	    userList.add(userWrapper);
	}
	

	@Override
	public String toString() {
		String result = "{\"userList\":[ ";
		for (UserNickWrapper userWrapper : userList) {
			result += userWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}
}
