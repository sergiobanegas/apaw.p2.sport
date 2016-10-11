package es.upm.miw.apaw.p2.sport;

import es.upm.miw.apaw.p2.sport.daos.DaoFactory;
import es.upm.miw.apaw.p2.sport.daos.memory.DaoFactoryMemory;
import es.upm.miw.apaw.p2.sport.web.http.HttpMethod;
import es.upm.miw.apaw.p2.sport.web.http.HttpRequest;
import es.upm.miw.apaw.p2.sport.web.http.HttpResponse;

public class ApiArchitectureMain {

    private static HttpRequest request;
    private static Server server;

	public void clearQueryParams() {
		request.clearQueryParams();
	}

	public static void request() {
		System.out.println(request);
		HttpResponse response = server.request(request);
		System.out.println(response);
		System.out.println("---------------------------------------ooo----------------------------------------");
	}

	public static void main(String[] args) {
	    server = new Server();
	    DaoFactory.setFactory(new DaoFactoryMemory());
	    request = new HttpRequest();
	    request.setMethod(HttpMethod.POST);
        request.setPath("users");
        request.setBody("uno:uno@gmail.com");
        request();
        request.setBody("dos:dos@gmail.com");
        request();
        request.setBody("uno:dos@gmail.com");
        request();
        
        request.setMethod(HttpMethod.GET);
        request.setPath("users");
        request.clearQueryParams();
        request();
        
        
        request.setMethod(HttpMethod.POST);
        request.setPath("sports");
        request.setBody("tenis");
        request();
        request();
        request.setBody("ajedrez");
        request();
        request.setMethod(HttpMethod.PUT);
        request.setPath("users/uno/sport");
        request.setBody("tenis");
        request();
        request.setBody("NoDeporte");
        request();
        request.setBody("tenis");
        request();
        request.setBody("ajedrez");
        request();
        request.setMethod(HttpMethod.GET);        
        request.setPath("users/search");
        request.addQueryParam("sport", "tenis");
        request();
        request.clearQueryParams();
        request.setMethod(HttpMethod.POST);
        request.setPath("noPath");
        request();
	}
}
