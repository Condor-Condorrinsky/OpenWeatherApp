package openweather;

import com.google.gson.*;

public class JsonHandler {
    
    public JsonHandler (){}

    public String getValueOutOfJsonString (String jsonString, String value){

        JsonObject object = JsonParser.parseString(jsonString).getAsJsonObject();
        return object.get(value).getAsString();
    }
}
