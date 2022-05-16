package openweather;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpHandler {
    
    private HttpClient client;

    public HttpHandler (){
        this.client = HttpClientBuilder.create().build();
    }

    public HttpClient getClient(){
        return client;
    }

}
