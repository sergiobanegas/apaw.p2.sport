package es.upm.miw.apaw.p2.sport.daos;

import java.util.List;

import es.upm.miw.apaw.p2.sport.entities.User;

public interface UserDao extends GenericDao<User, Integer> {
    List<User> findUserBySportName(String sportName);

    User findUserByNick(String userNick);

}
