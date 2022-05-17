package openweather;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Objects;

public class FileParser {
    
    private File cityDatabase;
    private final File API_key = new File("src/main/resources/API_key");

    private Scanner scanner;

    public FileParser(){}

    public String[] findCity (String city){

        String[] cityData = new String[] {null, null, null};

        try {
            scanner = new Scanner(cityDatabase);
        }
        catch (FileNotFoundException fileNotFoundException){
            System.err.println("Cannot find city database. Quiting!");
            System.exit(-1);
        }

        do {
            cityData = Arrays.stream(scanner.nextLine().split(", ")).toArray(String[]::new);
        }
        while(scanner.hasNext() && !Objects.equals(city, cityData[0]));

        return cityData;
    }

    public String readAPI_key (){

        try {
            scanner = new Scanner(API_key);
        }
        catch (FileNotFoundException fileNotFoundException){
            System.err.println("Cannot find API key. Quiting!");
            System.exit(-1);
        }

        return scanner.nextLine();
    }

    public void setCityDatabase (String path){
        cityDatabase = new File(path);
    }
}
