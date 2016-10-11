package es.upm.miw.apaw.p2.sport.api;

import es.upm.miw.apaw.p2.sport.controllers.SportController;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidSportNameException;
import es.upm.miw.apaw.p2.sport.exceptions.NotFoundSportNameException;
import es.upm.miw.apaw.p2.sport.wrappers.SportListWrapper;

public class SportResource {

    // POST **/votes body="themeId:vote"
    public void createSport(String name) throws InvalidSportNameException, NotFoundSportNameException {
        if (name == null) {
            throw new InvalidSportNameException("" + name);
        }
        new SportController().createSport(name);
    }

    // GET **/votes
    public SportListWrapper sportList() {
        return new SportController().sportList();
    }
    
    
}
