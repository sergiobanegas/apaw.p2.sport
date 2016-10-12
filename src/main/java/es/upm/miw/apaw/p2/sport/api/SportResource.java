package es.upm.miw.apaw.p2.sport.api;

import es.upm.miw.apaw.p2.sport.controllers.SportController;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidSportFieldException;
import es.upm.miw.apaw.p2.sport.exceptions.SportNameExistsException;
import es.upm.miw.apaw.p2.sport.wrappers.SportListWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.SportWrapper;

public class SportResource {

    public SportWrapper createSport(String sportName) throws SportNameExistsException, InvalidSportFieldException {
        this.validateField(sportName);
        if (new SportController().findSportByName(sportName) == null) {
            return new SportController().createSport(sportName);
        } else {
            throw new SportNameExistsException("" + sportName);
        }
    }

    private void validateField(String field) throws InvalidSportFieldException {
        if (field == null || field.isEmpty()) {
            throw new InvalidSportFieldException(field);
        }
    }

    public SportListWrapper sportList() {
        return new SportController().sportList();
    }

}
