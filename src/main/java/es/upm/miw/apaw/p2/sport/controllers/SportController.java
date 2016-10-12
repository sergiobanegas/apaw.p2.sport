package es.upm.miw.apaw.p2.sport.controllers;

import java.util.List;

import es.upm.miw.apaw.p2.sport.daos.DaoFactory;
import es.upm.miw.apaw.p2.sport.entities.Sport;
import es.upm.miw.apaw.p2.sport.wrappers.SportListWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.SportWrapper;

public class SportController {

    public SportListWrapper sportList() {
        List<Sport> sportList = DaoFactory.getFactory().getSportDao().findAll();
        SportListWrapper sportListWrapper = new SportListWrapper();
        for (Sport sport : sportList) {
            sportListWrapper.addSportWrapper(new SportWrapper(sport.getId(), sport.getName()));
        }
        return sportListWrapper;
    }

    public SportWrapper createSport(String sportName) {
        Sport sport = DaoFactory.getFactory().getSportDao().create(new Sport(sportName));
        return new SportWrapper(sport.getId(), sport.getName());
    }

    public SportWrapper findSportByName(String sportName) {
        Sport sport = DaoFactory.getFactory().getSportDao().findSportByName(sportName);
        if (sport != null) {
            return new SportWrapper(sport.getId(), sport.getName());
        } else {
            return null;
        }
    }

}
