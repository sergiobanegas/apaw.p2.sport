package es.upm.miw.apaw.p2.sport.wrappers;

import java.util.ArrayList;
import java.util.List;

public class SportListWrapper {
	List<SportWrapper> sportList = new ArrayList<>();

	public SportListWrapper() {
	}
	
	public List<SportWrapper> getSportList() {
		return sportList;
	}

	public void addSportWrapper(SportWrapper sportWrapper) {
	    sportList.add(sportWrapper);
	}

	@Override
	public String toString() {
		String result = "{\"sportList\":[ ";
		for (SportWrapper sportWrapper : sportList) {
			result += sportWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}

}
