package openweather;

import java.io.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpHandler {
    
    private HttpClient client;

    public HttpHandler (){
        this.client = HttpClientBuilder.create().build();
    }

    public void makeGetRequest(String[] city, String mode, String API_key){

        HttpGet getRequest = new HttpGet
        (String.format("https://api.openweathermap.org/data/2.5/onecall?lat=%1$s&lon=%2$s&exclude=%3$s&appid=%4$s",
        city[1], city[2], mode, API_key));

        getRequest.addHeader("accept", "application/json");
        HttpResponse response;

        try {
            response = client.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                System.err.println("Failed to fetch data - error code: " + response.getStatusLine().getStatusCode());
                System.exit(-1);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;
			System.out.println("============Output:============");
 
			// Simply iterate through XML response and show on console.
			while ((output = br.readLine()) != null) {
				System.out.println(output);
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
