package openweather;

import com.google.gson.*;

public class JsonHandler {

    private Gson gson;
    
    public JsonHandler (){
        this.gson = new Gson();
    }

    public String getValueOutOfJsonString (String jsonString, String value){

        JsonObject object = JsonParser.parseString(jsonString).getAsJsonObject();
        return object.get(value).getAsString();
    }
}
