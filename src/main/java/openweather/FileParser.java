package openweather;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Objects;

public class FileParser {
    
    private File cityDatabase;
    private Scanner scanner;

    public FileParser(){}

    public String[] findCity (String city){

        String[] cityData = new String[] {null, null, null};

        try {
            scanner = new Scanner(cityDatabase);

            do {
                cityData = Arrays.stream(scanner.nextLine().split(", ")).toArray(String[]::new);
            }
            while(scanner.hasNext() && !Objects.equals(city, cityData[0]));
        }
        catch (FileNotFoundException | NoSuchElementException exception){
            System.err.println("There was problem with parsing the file");
            System.exit(-1);
        }

        if (!Objects.equals(city, cityData[0])) {
            System.err.println("Given city is not present in the database. Quiting!");
            System.exit(-1);
        }

        return cityData;
    }

    public String readAPI_key (){

        InputStream in = getClass().getResourceAsStream("/API_key");
        scanner = new Scanner(in);

        return scanner.nextLine();
    }

    public void setCityDatabase (String path){
        cityDatabase = new File(path);
    }
}
