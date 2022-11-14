package fr.yghore.dyglib.Data;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeDeserializer implements JsonDeserializer <LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
    {
        return LocalDateTime.parse(jsonElement.getAsString(), DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss").withLocale(Locale.FRANCE));
    }
}

