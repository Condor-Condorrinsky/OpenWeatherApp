package openweather;

import com.google.gson.JsonParser;
import com.google.gson.JsonElement;

public class JsonHandler {
    
    public JsonHandler (){}

    public String getDailyTemps (String jsonString, String firstLevel, int i, String secondLevel, String thirdLevel){

        JsonElement element = JsonParser
        .parseString(jsonString)
        .getAsJsonObject()
        .getAsJsonArray(firstLevel)
        .get(i)
        .getAsJsonObject()
        .get(secondLevel)
        .getAsJsonObject()
        .get(thirdLevel);
        
        return element.getAsString();
    }

    public String getOthers (String jsonString, String firstLevel, int i, String secondLevel){

        JsonElement element = JsonParser
        .parseString(jsonString)
        .getAsJsonObject()
        .getAsJsonArray(firstLevel)
        .get(i)
        .getAsJsonObject()
        .get(secondLevel);

        return element.getAsString();
    }
}
