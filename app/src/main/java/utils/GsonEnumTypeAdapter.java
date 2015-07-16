package utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public final class GsonEnumTypeAdapter<T extends Enum<T>> implements JsonSerializer<T>, JsonDeserializer<T>{
    public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.name());
    }

    @SuppressWarnings("cast")
    public T deserialize(JsonElement json, Type classOfT, JsonDeserializationContext context)
            throws JsonParseException {
        try {
            T value = Enum.valueOf((Class<T>) classOfT, json.getAsString());
            return value;
        }catch(Throwable e){
        }
        return null;
    }

    @Override
    public String toString() {
        return GsonEnumTypeAdapter.class.getSimpleName();
    }

}
