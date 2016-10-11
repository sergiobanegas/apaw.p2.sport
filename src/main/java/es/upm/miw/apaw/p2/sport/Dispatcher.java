package es.upm.miw.apaw.p2.sport;

import es.upm.miw.apaw.p2.sport.api.SportResource;
import es.upm.miw.apaw.p2.sport.api.UserResource;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidRequestException;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidUserFieldException;
import es.upm.miw.apaw.p2.sport.exceptions.SportNameExistsException;
import es.upm.miw.apaw.p2.sport.exceptions.UserNickExistsException;
import es.upm.miw.apaw.p2.sport.exceptions.VoidParameterException;
import es.upm.miw.apaw.p2.sport.web.http.HttpRequest;
import es.upm.miw.apaw.p2.sport.web.http.HttpResponse;
import es.upm.miw.apaw.p2.sport.web.http.HttpStatus;

public class Dispatcher {

    private UserResource userResource = new UserResource();

    private SportResource sportResource = new SportResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        // **/users
        if ("users".equals(request.getPath())) {
            response.setBody(userResource.userList().toString());
        } else if ("users".equals(request.paths()[0]) && "search".equals(request.paths()[1])) {
            if (request.getParams().containsKey("sport") && request.getParams().get("sport") != null) {
                try {
                    response.setBody(userResource.findUserBySportName(request.getParams().get("sport")).toString());
                } catch (Exception e) {
                    responseError(response, e);
                }
            } else {
                responseError(response, new VoidParameterException("sport"));
            }

            // **/sports
        } else if ("sports".equals(request.getPath())) {
            response.setBody(sportResource.sportList().toString());
        } else {
            responseError(response, new InvalidRequestException(request.getPath()));
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        switch (request.getPath()) {
        // POST **/users body="userName:userEmail"
        case "users":
            // Injectar parámetros...
            String userNick = request.getBody().split(":")[0];
            String userEmail = request.getBody().split(":")[1];
            try {
                if (userResource.findUserByNick(userNick) == null) {
                    userResource.createUser(userNick, userEmail);
                    response.setStatus(HttpStatus.CREATED);
                } else {
                    responseError(response, new UserNickExistsException(userNick));
                }
            } catch (InvalidUserFieldException e) {
                this.responseError(response, e);
            }
            break;
        // POST sports body="sportName"
        case "sports":
            try {
                if (sportResource.findSportByName(request.getBody()) == null) {
                    sportResource.createSport(request.getBody());
                    response.setStatus(HttpStatus.CREATED);
                } else {
                    responseError(response, new SportNameExistsException(request.getBody()));
                }

            } catch (Exception e) {
                responseError(response, e);
            }
            break;
        default:
            responseError(response, new InvalidRequestException(request.getPath()));
            break;
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {

        if (request.getPath() == null) {
            responseError(response, new InvalidRequestException(request.getPath()));
        } else {
            switch (request.paths()[0]) {
            case "users":
                if ("sport".equals(request.paths()[2])) {
                    try {
                        userResource.addUserSport(request.paths()[1], request.getBody());
                    } catch (Exception e) {
                        responseError(response, e);
                    }
                    response.setStatus(HttpStatus.OK);
                } else {
                    responseError(response, new VoidParameterException("sport"));
                }
                break;
            default:

                break;
            }
        }

    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        switch (request.getPath()) {
        default:
            responseError(response, new InvalidRequestException(request.getPath()));
            break;
        }
    }

}
