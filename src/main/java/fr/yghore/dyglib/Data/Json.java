package fr.yghore.dyglib.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.*;

public class Json
{


    private Class<? extends Salvageable> className;
    private String path;

    public Json(Class<? extends Salvageable> className, String path) {
        this.className = className;
        this.path = path;
    }

    public void save(Salvageable ob){
        File file = new File(path);
        try {
            if(!file.exists()){file.createNewFile();}
            Gson gson = new GsonBuilder().create();
            String jsonText = gson.toJson(ob);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonText);
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Salvageable load() throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(new FileReader(this.path), this.className);
    }


}
