package es.upm.miw.apaw.p2.sport.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.apaw.p2.sport.daos.DaoFactory;
import es.upm.miw.apaw.p2.sport.entities.Sport;
import es.upm.miw.apaw.p2.sport.entities.User;
import es.upm.miw.apaw.p2.sport.wrappers.SportWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.UserNickEmailListWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.UserNickEmailWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.UserNickListWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.UserNickWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.UserWrapper;

public class UserController {

    public UserNickEmailListWrapper userList() {
        List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
        UserNickEmailListWrapper userListWrapper = new UserNickEmailListWrapper();
        for (User user : userList) {
            userListWrapper.addUserNickEmailWrapper(new UserNickEmailWrapper(user.getNick(), user.getEmail()));
        }
        return userListWrapper;
    }

    public UserWrapper findUserByNick(String userNick) {
        User user = DaoFactory.getFactory().getUserDao().findUserByNick(userNick);
        if (user != null) {
            return createUserWrapper(user);
        } else {
            return null;
        }
    }

    public boolean userPracticesSport(String userNick, String sportName) {
        User user = DaoFactory.getFactory().getUserDao().findUserByNick(userNick);
        return user.hasSport(sportName);
    }

    public UserWrapper createUser(String userNick, String userEmail) {
        return createUserWrapper(DaoFactory.getFactory().getUserDao().create(new User(userNick, userEmail)));
    }

    public UserNickListWrapper findUsersBySportName(String sportName) {
        List<User> userList = DaoFactory.getFactory().getUserDao().findUsersBySportName(sportName);
        UserNickListWrapper userNickListWrapper = new UserNickListWrapper();
        for (User user : userList) {
            userNickListWrapper.addUserNickWrapper(new UserNickWrapper(user.getNick()));
        }
        return userNickListWrapper;
    }

    public UserWrapper addUserSport(String userNick, String sportName) {
        User user = DaoFactory.getFactory().getUserDao().findUserByNick(userNick);
        SportWrapper sportWrapper = new SportController().findSportByName(sportName);
        user.addSport(new Sport(sportWrapper.getId(), sportWrapper.getName()));// ERROR
        DaoFactory.getFactory().getUserDao().update(user);
        return createUserWrapper(user);
    }

    private UserWrapper createUserWrapper(User user) {
        List<SportWrapper> userSports = new ArrayList<SportWrapper>();
        for (Sport sport : user.getSports()) {
            userSports.add(new SportWrapper(sport.getId(), sport.getName()));
        }
        return new UserWrapper(user.getId(), user.getNick(), user.getEmail(), userSports);
    }

}
