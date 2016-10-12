package es.upm.miw.apaw.p2.sport.api;

import es.upm.miw.apaw.p2.sport.controllers.SportController;
import es.upm.miw.apaw.p2.sport.controllers.UserController;
import es.upm.miw.apaw.p2.sport.exceptions.NotFoundSportNameException;
import es.upm.miw.apaw.p2.sport.exceptions.NotFoundUserNickException;
import es.upm.miw.apaw.p2.sport.exceptions.SportNameUserExistsException;
import es.upm.miw.apaw.p2.sport.exceptions.UserNickExistsException;
import es.upm.miw.apaw.p2.sport.wrappers.UserNickEmailListWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.UserNickListWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.UserWrapper;

public class UserResource {

    public UserNickEmailListWrapper userList() {
        return new UserController().userList();
    }

    public UserWrapper createUser(String userNick, String userEmail) throws UserNickExistsException {
        if (new UserController().findUserByNick(userNick) == null) {
            return new UserController().createUser(userNick, userEmail);
        } else {
            throw new UserNickExistsException(userNick);
        }

    }

    public UserNickListWrapper findUserBySportName(String sportName) throws NotFoundSportNameException {
        if (new SportController().findSportByName(sportName) != null) {
            return new UserController().findUsersBySportName(sportName);
        } else {
            throw new NotFoundSportNameException("" + sportName);
        }
    }

    public UserWrapper addUserSport(String userNick, String sportName)
            throws SportNameUserExistsException, NotFoundSportNameException, NotFoundUserNickException {
        if (new SportController().findSportByName(sportName) == null) {
            throw new NotFoundSportNameException("" + sportName);
        } else if (new UserController().findUserByNick(userNick) == null) {
            throw new NotFoundUserNickException("" + userNick);
        } else if (new UserController().userPracticesSport(userNick, sportName)) {
            throw new SportNameUserExistsException("" + userNick, sportName);
        } else {
            return new UserController().addUserSport(userNick, sportName);
        }
    }

}
