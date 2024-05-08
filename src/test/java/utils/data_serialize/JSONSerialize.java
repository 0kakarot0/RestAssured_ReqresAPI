package utils.data_serialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JSONSerialize {

    private static final Gson gson = new Gson();
    private static final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();

    public static String serializeObjectAsJson(Object object) {
        return gson.toJson(object);
    }

    /**
     * Deserialize a JSON string into an object of a specified class.
     *
     * @param json  JSON string to deserialize.
     * @param clazz The class of T.
     * @param <T>   The target type.
     * @return The deserialized object.
     */
    public static <T> T deserializeJsonToObject(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    /**
     * Deserialize a JSON string into a List of objects of a specified class.
     *
     * @param json  JSON string to deserialize.
     * @param clazz The class of T.
     * @param <T>   The target type.
     * @return A list of deserialized objects.
     */
    public static <T> List<T> deserializeJsonToList(String json, Class<T> clazz) {
        Type listType = TypeToken.getParameterized(List.class, clazz).getType();
        return gson.fromJson(json, listType);
    }

    /**
     * Pretty-print a JSON string.
     *
     * @param json JSON string to pretty-print.
     * @return Pretty-printed JSON string.
     */
    public static String prettyPrintJson(String json) {
        JsonElement jsonElement = JsonParser.parseString(json);
        return prettyGson.toJson(jsonElement);
    }

    /**
     * Verify if the input string is a valid JSON.
     *
     * @param json JSON string to validate.
     * @return True if the string is valid JSON, False otherwise.
     */
    public static boolean isValidJson(String json) {
        try {
            JsonParser.parseString(json);
            return true;
        } catch (JsonParseException e) {
            return false;
        }
    }

    /**
     * Convert a List to a JSON array string.
     *
     * @param list The list to convert.
     * @param <T>  The type of elements in the list.
     * @return JSON array string.
     */
    public static <T> String listToJsonArray(List<T> list) {
        return gson.toJson(list);
    }

    /**
     * Parse a JSON string to a JsonObject.
     *
     * @param json JSON string to parse.
     * @return JsonObject representation of the JSON string.
     */
    public static JsonObject parseJsonObject(String json) {
        return JsonParser.parseString(json).getAsJsonObject();
    }

    /**
     * Parse a JSON string to a JsonArray.
     *
     * @param json JSON string to parse.
     * @return JsonArray representation of the JSON string.
     */
    public static JsonArray parseJsonArray(String json) {
        return JsonParser.parseString(json).getAsJsonArray();
    }

    /**
     * Merge two JSON objects into one.
     *
     * @param json1 First JSON object string.
     * @param json2 Second JSON object string.
     * @return Merged JSON object string.
     */
    public static String mergeJsonObjects(String json1, String json2) {
        JsonObject jsonObject1 = JsonParser.parseString(json1).getAsJsonObject();
        JsonObject jsonObject2 = JsonParser.parseString(json2).getAsJsonObject();
        jsonObject2.entrySet().forEach(entry -> jsonObject1.add(entry.getKey(), entry.getValue()));
        return gson.toJson(jsonObject1);
    }
}