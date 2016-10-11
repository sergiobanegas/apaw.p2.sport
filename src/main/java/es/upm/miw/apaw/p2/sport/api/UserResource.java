package es.upm.miw.apaw.p2.sport.api;

import es.upm.miw.apaw.p2.sport.controllers.SportController;
import es.upm.miw.apaw.p2.sport.controllers.UserController;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidUserFieldException;
import es.upm.miw.apaw.p2.sport.exceptions.NotFoundSportNameException;
import es.upm.miw.apaw.p2.sport.exceptions.SportNameUserExistsException;
import es.upm.miw.apaw.p2.sport.wrappers.UserNickEmailListWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.UserNickListWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.UserWrapper;

public class UserResource {

    // GET **/themes
    public UserNickEmailListWrapper userList() {
        return new UserController().userList();
    }

    // POST **/themes body="themeName"
    public void createUser(String userNick, String userEmail) throws InvalidUserFieldException {
        this.validateField(userNick);
        this.validateField(userEmail);
        new UserController().createUser(userNick, userEmail);
    }

    private void validateField(String field) throws InvalidUserFieldException {
        if (field == null || field.isEmpty()) {
            throw new InvalidUserFieldException(field);
        }
    }

    // GET **themes/{id}/overage
    public UserNickListWrapper findUserBySportName(String sportName) throws NotFoundSportNameException {
        UserNickListWrapper usernickListWrapper = new UserController().findUserBySportName(sportName);
        if (usernickListWrapper != null) {
            return usernickListWrapper;
        } else {
            throw new NotFoundSportNameException("" + sportName);
        }
    }

    public UserWrapper findUserByNick(String userNick) {
        return new UserController().findUserByNick(userNick);
    }

    public UserWrapper addUserSport(String userNick, String sportName) throws SportNameUserExistsException, NotFoundSportNameException {
        if (new SportController().findSportByName(sportName) != null) {
            if (!new UserController().userPracticesSport(userNick, sportName)) {
                return new UserController().addUserSport(userNick, sportName);
            } else {
                throw new SportNameUserExistsException("" + userNick, sportName);
            }
        } else {
            throw new NotFoundSportNameException("" + sportName);
        }
    }

}
