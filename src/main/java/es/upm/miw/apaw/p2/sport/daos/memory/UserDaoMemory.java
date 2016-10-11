package es.upm.miw.apaw.p2.sport.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.apaw.p2.sport.daos.UserDao;
import es.upm.miw.apaw.p2.sport.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User>implements UserDao {

    public UserDaoMemory() {
        this.setMap(new HashMap<Integer, User>());
    }

    @Override
    protected Integer getId(User entity) {
        return entity.getId();
    }

    @Override
    protected void setId(User entity, Integer id) {
        entity.setId(id);
    }

    @Override
    public User findUserByNick(String userNick) {
        List<User> users = this.findAll();
        for (User user : users) {
            if (user.getNick().equals(userNick)) {
               return user;
            }
        }
        return null;
    }
    
    @Override
    public List<User> findUserBySportName(String sportName) {
        List<User> users = this.findAll();
        List<User> usersResult = new ArrayList<>();
        for (User user : users) {
            if (user.hasSport(sportName)) {
                usersResult.add(user);
            }
        }
        return usersResult;
    }

}
