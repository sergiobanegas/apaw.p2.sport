package es.upm.miw.apaw.p2.sport.controllers;

import java.util.List;

import es.upm.miw.apaw.p2.sport.daos.DaoFactory;
import es.upm.miw.apaw.p2.sport.entities.Sport;
import es.upm.miw.apaw.p2.sport.entities.User;
import es.upm.miw.apaw.p2.sport.wrappers.UserListWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.UserWrapper;

public class UserController {

    public UserListWrapper userList() {
        List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
        UserListWrapper userListWrapper = new UserListWrapper();
        for (User user : userList) {
            userListWrapper.addUserWrapper(new UserWrapper(user.getId(), user.getNick(), user.getEmail()));
        }
        return userListWrapper;
    }
    
    public UserWrapper findUserByNick(String userNick) {
        User user= DaoFactory.getFactory().getUserDao().findUserByNick(userNick);
        if (user!=null){
            return new UserWrapper(user.getId(), user.getNick(), user.getEmail());
        }else{
            return null;
        }
           
    }

    public void createUser(String userNick, String userEmail) {
        if (DaoFactory.getFactory().getUserDao().findUserByNick(userNick)!=null){
        }else{
            DaoFactory.getFactory().getUserDao().create(new User(userNick, userEmail));
        }     
    }

    public UserListWrapper findUserBySportName(String sportName) {
        List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
        UserListWrapper userListWrapper = new UserListWrapper();
        for (User user : userList) {
            if (user.hasSport(sportName)) {
                userListWrapper.addUserWrapper(new UserWrapper(user.getId(), user.getNick(), user.getEmail()));
            }
        }
        return userListWrapper;
    }

    public UserWrapper addUserSport(String userNick, String sportName) {
        User user = DaoFactory.getFactory().getUserDao().findUserByNick(userNick);
        if (user!=null){
            user.addSport(new Sport(sportName));
            DaoFactory.getFactory().getUserDao().update(user);
        }
        return new UserWrapper(user.getId(), user.getNick(), user.getEmail());
    }

}
