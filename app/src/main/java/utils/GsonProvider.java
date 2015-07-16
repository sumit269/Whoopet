package utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonProvider {

    private static Gson gson = (new GsonBuilder())
            .registerTypeHierarchyAdapter(Enum.class, new GsonEnumTypeAdapter())
            .setDateFormat(DateUtils.SERVICES_DATE_FORMAT)
            .create();

    public static Gson getDefaultGson() {
        return gson;
    }
}
