package es.upm.miw.apaw.p2.sport;

import es.upm.miw.apaw.p2.sport.web.http.HttpRequest;
import es.upm.miw.apaw.p2.sport.web.http.HttpResponse;

public class Server {
	private Dispatcher dispatcher = new Dispatcher();

	public HttpResponse request(HttpRequest request) {
		HttpResponse response = new HttpResponse();
		switch (request.getMethod()) {
		case POST:
			dispatcher.doPost(request, response);
			break;
		case GET:
			dispatcher.doGet(request, response);
			break;
		case PUT:
			dispatcher.doPut(request, response);
			break;
		case DELETE:
			dispatcher.doDelete(request, response);
			break;
		default:
		}
		return response;
	}

}