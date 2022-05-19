package openweather;

public enum Mode {

    HOURLY("hourly", "current,minutely,daily,alerts"),
    DAILY("daily", "current,minutely,hourly,alerts");

    private String type;
    private String excluded;

    Mode (String type, String excluded){
        this.type = type;
        this.excluded = excluded;
    }

    public String getType (){
        return type;
    }

    public String getExcluded(){
        return excluded;
    }
}
