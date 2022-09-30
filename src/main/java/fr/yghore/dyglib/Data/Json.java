package fr.yghore.dyglib.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.json.JSONTokener;

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
            JSONObject jo = new JSONObject(ob);

                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(jo.toString());
                fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Salvageable load() throws FileNotFoundException {
        JSONObject jo = new JSONObject(new JSONTokener(new FileReader(this.path)));
        Gson gson = new GsonBuilder().create();
        return (Salvageable) gson.fromJson(jo.toString(), this.className);
    }


}
