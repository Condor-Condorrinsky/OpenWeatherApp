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

        String excluded = chooseExcluded(args[1]);

        String response = new HttpHandler().makeGetRequest(city, excluded, key);
        
        printResults(city, mode, key);
    }

    public static String chooseMode(String mode){

        switch (mode){
            case "daily":
                return Mode.DAILY.getType();
            case "hourly":
                return Mode.HOURLY.getType();
            default:
                System.out.println("Did not choose correct mode, defaulting to daily\n");
                return Mode.DAILY.getType();
        }
    }

    public static String chooseExcluded(String mode){

        switch (mode){
            case "daily":
                return Mode.DAILY.getExcluded();
            case "hourly":
                return Mode.HOURLY.getExcluded();
            default:
                System.out.println("Did not choose correct mode, defaulting to daily\n");
                return Mode.DAILY.getExcluded();
        }
    }

    public static void printResults(String response, String excluded){

        JsonHandler handler = new JsonHandler();

        switch (mode){
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