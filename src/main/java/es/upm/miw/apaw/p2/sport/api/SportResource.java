package es.upm.miw.apaw.p2.sport.api;

import es.upm.miw.apaw.p2.sport.controllers.SportController;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidSportNameException;
import es.upm.miw.apaw.p2.sport.exceptions.NotFoundSportNameException;
import es.upm.miw.apaw.p2.sport.exceptions.SportNameExistsException;
import es.upm.miw.apaw.p2.sport.wrappers.SportListWrapper;

public class SportResource {

    // POST **/votes body="themeId:vote"
    public void createSport(String sportName) throws InvalidSportNameException, NotFoundSportNameException, SportNameExistsException {
        if (sportName == null) {
            throw new InvalidSportNameException("" + sportName);
        }
        if (new SportController().findSportByName(sportName) == null) {
            new SportController().createSport(sportName);
        } else {
            throw new SportNameExistsException("" + sportName);
        }

    }

    // GET **/votes
    public SportListWrapper sportList() {
        return new SportController().sportList();
    }

}
