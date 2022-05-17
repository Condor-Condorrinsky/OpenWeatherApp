package openweather;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpHandler {
    
    private HttpClient client;

    public HttpHandler (){
        this.client = HttpClientBuilder.create().build();
    }

    public void makeGetRequest(String[] city){

        HttpGet getRequest = new HttpGet("placeholder");
        getRequest.addHeader("accept", "application/json");
        HttpResponse response;

        try {
            response = client.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                System.err.println("Failed to fetch data - error code: " + response.getStatusLine().getStatusCode());
                System.exit(-1);
            }
        }
        catch (IOException exc) {
            System.err.println("Couldn't execute http request. Quiting!");
            System.exit(-1);
        }

        
    }

    public HttpClient getClient(){
        return client;
    }

}
