package openweather;

public class Main{

    public static void main(String[] args) {
        
        FileParser fp = new FileParser();
        String[] arr = fp.findCity("rome");
        System.out.println(arr.toString());
    }
}