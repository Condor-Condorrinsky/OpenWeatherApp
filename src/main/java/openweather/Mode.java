package openweather;

public enum Mode {

    HOURLY("current,minutely,daily,alerts"),
    DAILY("current,minutely,hourly,alerts");

    private String pattern;

    Mode (String text){
        this.pattern = text;
    }

    public String getPattern (){
        return pattern;
    }
}
