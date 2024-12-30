package edp.microservices.connector;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;


public class ApiConnector {
    public void fetch(String uri) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest.Builder request = HttpRequest.newBuilder();


    }
}
