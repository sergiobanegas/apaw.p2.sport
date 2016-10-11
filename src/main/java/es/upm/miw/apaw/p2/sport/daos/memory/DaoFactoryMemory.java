package es.upm.miw.apaw.p2.sport.daos.memory;

import es.upm.miw.apaw.p2.sport.daos.DaoFactory;
import es.upm.miw.apaw.p2.sport.daos.SportDao;
import es.upm.miw.apaw.p2.sport.daos.UserDao;

public class DaoFactoryMemory extends DaoFactory {

    private SportDao sportDao;

    private UserDao userDao;

    public DaoFactoryMemory() {
    }

    @Override
    public SportDao getSportDao() {
        if (sportDao == null) {
            sportDao = new SportDaoMemory();
        }
        return sportDao;
    }

    @Override
    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoMemory();
        }
        return userDao;
    }

}
