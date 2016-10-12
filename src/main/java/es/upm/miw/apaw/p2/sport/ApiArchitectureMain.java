package es.upm.miw.apaw.p2.sport;

import es.upm.miw.apaw.p2.sport.daos.DaoFactory;
import es.upm.miw.apaw.p2.sport.daos.memory.DaoFactoryMemory;
import es.upm.miw.apaw.p2.sport.web.http.HttpMethod;
import es.upm.miw.apaw.p2.sport.web.http.HttpRequest;
import es.upm.miw.apaw.p2.sport.web.http.HttpResponse;

public class ApiArchitectureMain {

    private static HttpRequest request;

    private static Server server;

    public static void request(HttpMethod method, String path, String body) {
        request.setMethod(method);
        request.setPath(path);
        request.setBody(body);
        System.out.println(request);
        HttpResponse response = server.request(request);
        System.out.println(response);
        System.out.println("---------------------------------------ooo----------------------------------------");
    }

    public static void main(String[] args) {
        server = new Server();
        DaoFactory.setFactory(new DaoFactoryMemory());
        request = new HttpRequest();
        request(HttpMethod.POST, "users", "uno:uno@gmail.com");
        request(HttpMethod.POST, "users", "dos:dos@gmail.com");
        request(HttpMethod.POST, "users", "uno:dos@gmail.com");
        request(HttpMethod.GET, "users", null);
        request(HttpMethod.POST, "sports", "tenis");
        request(HttpMethod.POST, "sports", "tenis");
        request(HttpMethod.POST, "sports", "ajedrez");
        request(HttpMethod.PUT, "users/uno/sport", "tenis");
        request(HttpMethod.PUT, "users/uno/sport", "noDeporte");
        request(HttpMethod.PUT, "users/uno/sport", "tenis");
        request(HttpMethod.PUT, "users/uno/sport", "ajedrez");
        request.addQueryParam("sport", "tenis");
        request(HttpMethod.GET, "users/search", null);
        request.clearQueryParams();
        request(HttpMethod.POST, "noPath", null);
    }
}
