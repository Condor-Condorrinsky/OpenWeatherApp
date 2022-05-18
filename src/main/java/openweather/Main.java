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
                System.out.println("Did not choose correct mode, defaulting to daily");
                mode = Mode.DAILY.getPattern();
                break;
        }
        
        HttpHandler handler = new HttpHandler();
        handler.makeGetRequest(city, mode, key);
    }
}