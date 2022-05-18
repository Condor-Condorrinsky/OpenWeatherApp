package openweather;

//import java.util.Arrays;

public class Main{

    public static void main(String[] args) {
        // args[0] - ścieżka do pliku, args[1] - rodzaj prognozy, args[2] - nazwa miasta

        FileParser parser = new FileParser();
        String key = parser.readAPI_key();
        parser.setCityDatabase(args[0]);
        String[] city = parser.findCity(args[2]);

        String mode;

        switch (args[1]){
            case "daily":
                mode = Mode.DAILY.getPattern();
                break;
            case "hourly":
                mode = Mode.HOURLY.getPattern();
                break;
            default:
                System.out.println("Did not choose correct mode, defaulting to daily\n");
                mode = Mode.DAILY.getPattern();
                break;
        }
        
        String response = new HttpHandler().makeGetRequest(city, mode, key);
        System.out.println(response);
        JsonHandler handler = new JsonHandler();

        switch (mode){
            case "daily":

                break;
            case "hourly":

                break;
        }
    }
}