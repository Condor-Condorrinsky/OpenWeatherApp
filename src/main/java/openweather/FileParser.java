package openweather;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {
    
    private final File cityDatabase = new File("../../../resources/city_list");
    private final File API_key = new File("../../../resources/API_key");

    private Scanner scanner;

    public FileParser(){}

    public void findCity (String city){

        try {
            scanner = new Scanner(cityDatabase);
            }
            catch (FileNotFoundException fileNotFoundException){
                System.err.println("Cannot find city database. Quting!");
                System.exit(-1);
            }
    }

    public String readAPI_key (){

        try {
            scanner = new Scanner(API_key);
            }
            catch (FileNotFoundException fileNotFoundException){
                System.err.println("Cannot find API key. Quting!");
                System.exit(-1);
            }

        return scanner.nextLine();
    }
}
