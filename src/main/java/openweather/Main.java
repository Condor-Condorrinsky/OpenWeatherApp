package openweather;

public class Main{

    public static void main(String[] args) {
        // args[0] - ścieżka do pliku, args[1] - rodzaj prognozy, args[2] - nazwa miasta

        if (args.length != 3) {
            System.out.println("Wrong number of args. Quiting!");
            System.exit(-1);
        }

        FileParser parser = new FileParser();
        String key = parser.readAPI_key();
        parser.setCityDatabase(args[0]);
        String[] city = parser.findCity(args[2]);

        String mode;

        switch (args[1]){
            case "daily":
                mode = Mode.DAILY.getExcluded();
                break;
            case "hourly":
                mode = Mode.HOURLY.getExcluded();
                break;
            default:
                System.out.println("Did not choose correct mode, defaulting to daily\n");
                mode = Mode.DAILY.getExcluded();
                args[1] = Mode.DAILY.getType();
                break;
        }
        
        String response = new HttpHandler().makeGetRequest(city, mode, key);
        JsonHandler handler = new JsonHandler();

        switch (args[1]){
            case "daily":
                for (int i = 0; i < 8; i++){
                    System.out.println(String.format("Minimal temperature in %d days", i));
                    System.out.println(handler.getDailyTemps(response, "daily", i, "temp", "min") + "℃");
                    System.out.println(String.format("Maximal temperature in %d days", i));
                    System.out.println(handler.getDailyTemps(response, "daily", i, "temp", "max") + "℃");
                    System.out.println(String.format("Average temperature in %d days", i));
                    System.out.println(handler.getDailyTemps(response, "daily", i, "temp", "day") + "℃");
                    System.out.println(String.format("Probability of rain in %d days", i));
                    System.out.println(handler.getOthers(response, "daily", i, "humidity") + "%");
                }
               break;
            case "hourly":
                for (int i = 0; i < 48; i++){
                    // JSON dla hourly nie zawiera temperatury minimalnej i maksymalnej
                    System.out.println(String.format("Temperature in %d hours", i));
                    System.out.println(handler.getOthers(response, "hourly", i, "temp") + "℃");
                    System.out.println(String.format("Probability of rain in %d hours", i));
                    System.out.println(handler.getOthers(response, "hourly", i, "humidity") + "%");
                }
                break;
        }
    }
}