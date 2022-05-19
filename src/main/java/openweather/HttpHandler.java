package openweather;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpHandler {
    
    private HttpClient client;

    public HttpHandler (){
        this.client = HttpClientBuilder.create().build();
    }

    public String makeGetRequest(String[] city, String mode, String API_key){

        HttpGet getRequest = new HttpGet
        (String.format("https://api.openweathermap.org/data/2.5/onecall?lat=%1$s&lon=%2$s&units=metric&exclude=%3$s&appid=%4$s",
        city[1], city[2], mode, API_key));

        getRequest.addHeader("accept", "application/json");
        HttpResponse response = null;
        String jsonString = null;

        try {
            response = client.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                System.err.println("Failed to fetch data - error code: " + response.getStatusLine().getStatusCode());
                System.exit(-1);
            }

            InputStream is = response.getEntity().getContent();
            response.getEntity().getContent();
            jsonString = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
                  .lines()
                  .collect(Collectors.joining("\n"));
        }
        catch (IOException exc) {
            System.err.println("Couldn't execute http request. Quiting!");
            System.exit(-1);
        }

        return jsonString;
    }
}
