package fr.yghore.dyglib.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.*;
import java.time.LocalDateTime;

public class Json
{

    private final static Gson GSON = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
            .setPrettyPrinting()
            .create();
    private transient String path;

    public Json(String path) {
        this.path = path;
    }

    public Json(){}


    public void save(){
        File file = new File(path);
        try {
            if(!file.exists()){file.createNewFile();}


            String jsonText = GSON.toJson(this);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonText);
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Json load(String path, Class<? extends Salvageable> className) throws FileNotFoundException {

            Json json = (Json) GSON.fromJson(new FileReader(path), className);
            json.path = path;
            return json;



    }

    public Json setPath(String path)
    {
        this.path = path;
        return this;
    }


}
