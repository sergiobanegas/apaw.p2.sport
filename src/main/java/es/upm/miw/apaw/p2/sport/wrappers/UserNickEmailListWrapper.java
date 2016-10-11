package es.upm.miw.apaw.p2.sport.wrappers;

import java.util.ArrayList;
import java.util.List;

public class UserNickEmailListWrapper {
    List<UserNickEmailWrapper> userList;

    public UserNickEmailListWrapper() {
        userList = new ArrayList<>();
    }

    public List<UserNickEmailWrapper> getUserList() {
        return userList;
    }

    public void addUserNickEmailWrapper(UserNickEmailWrapper userWrapper) {
        userList.add(userWrapper);
    }

    @Override
    public String toString() {
        String result = "{\"userList\":[ ";
        for (UserNickEmailWrapper userWrapper : userList) {
            result += userWrapper.toString() + ",";
        }
        return result.substring(0, result.length() - 1) + "]}";
    }
}
